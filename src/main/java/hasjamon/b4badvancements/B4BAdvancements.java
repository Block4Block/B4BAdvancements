package hasjamon.b4badvancements;

import com.comphenix.protocol.utility.MinecraftReflection;
import com.pay4players.Pay4PlayersAPI;
import hasjamon.b4badvancements.advancements.*;
import hasjamon.b4badvancements.commands.GivePointsCommand;
import hasjamon.b4badvancements.listeners.*;
import net.minecraft.locale.LocaleLanguage;
import net.roxeez.advancement.AdvancementManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Logger;

public class B4BAdvancements extends JavaPlugin implements Listener {
    public static boolean canUseReflection = true;
    public static boolean canGivePoints = true;
    private static final LinkedList<TransferInfo> failedTransfers = new LinkedList<>();
    private static B4BAdvancements plugin;
    private final PluginManager pluginManager = getServer().getPluginManager();
    private final AdvancementManager advManager = new AdvancementManager(this);

    @Override
    public void onEnable(){
        plugin = this;
        checkSoftDependencies();
        registerAdvancements();
        registerEvents();
        populateFailedTransfers();
        setCommandExecutors();

        // Retry transfers one every 20 ticks (= 1 second)
        getServer().getScheduler().scheduleSyncRepeatingTask(this, this::retryTransfers, 0, 20);
    }

    public static void awardCriteria(Player player, String advancementID, String criteriaID){
        var key = new NamespacedKey(plugin, advancementID);
        var adv = Bukkit.getServer().getAdvancement(key);

        if (adv != null) {
            player.getAdvancementProgress(adv).awardCriteria(criteriaID);
        }
    }

    public static String getItemName(ItemStack head){
        try{
            Object refItemStack = MinecraftReflection.getMinecraftItemStack(head);
            return LocaleLanguage.a().a(((net.minecraft.world.item.ItemStack) refItemStack).y().getString());
        } catch (ClassCastException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void givePoints(OfflinePlayer player, int amount){
        givePoints(new TransferInfo(player.getName(), player.getUniqueId().toString(), amount, UUID.randomUUID().toString(), -1, -1, 0));
    }

    public static void givePoints(TransferInfo transfer){
        String playerName = transfer.playerName();
        int amount = transfer.amount();
        String tid = transfer.id();
        int retries = transfer.retries();
        String pid = transfer.playerUUID();
        Logger log = plugin.getLogger();

        log.info("Transfer " + tid + ": " + amount + " points to " + pid + " (" + playerName + ")");

        if(canGivePoints) {
            Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
                try {
                    int statusCode = Pay4PlayersAPI.transferPoints(pid, amount);

                    switch(statusCode) {
                        case 200 -> log.info("Transfer " + tid + " succeeded");
                        case 400 -> log.warning("Transfer " + tid + " failed: Malformed JSON");
                        case 401 -> log.warning("Transfer " + tid + " failed: Unknown/invalid token");
                        case 402 -> log.warning("Transfer " + tid + " failed: Insufficient points");
                        case 403 -> log.warning("Transfer " + tid + " failed: Sender and recipient were the same");
                        case 502 -> log.warning("Transfer " + tid + " failed: Server unavailable");
                        default -> log.severe("Unknown status code (" + statusCode + "). Transfer " + tid + " failed?");
                    }

                    if(statusCode != 200){
                        saveFailedTransfer(new TransferInfo(playerName, pid, amount, tid, System.currentTimeMillis(), retries + 1, statusCode));
                    }
                } catch (IOException | InterruptedException e) {
                    log.severe("Error: Transfer " + tid + " failed");
                    e.printStackTrace();
                    saveFailedTransfer(new TransferInfo(playerName, pid, amount, tid, System.currentTimeMillis(), retries + 1, -1));
                }
            });
        }
    }

    private void populateFailedTransfers() {
        ConfigurationSection cfg = plugin.getConfig().getConfigurationSection("failed-transfers");

        if(cfg != null) {
            Set<String> transferIDs = cfg.getKeys(false);

            for(String tID : transferIDs) {
                String playerName = plugin.getConfig().getString("failed-transfers." + tID + ".player-name");
                String playerUUID = plugin.getConfig().getString("failed-transfers." + tID + ".player-uuid");
                int amount = plugin.getConfig().getInt("failed-transfers." + tID + ".amount");
                long lastTry = plugin.getConfig().getLong("failed-transfers." + tID + ".last-try");
                int retries = plugin.getConfig().getInt("failed-transfers." + tID + ".retries");
                int statusCode = plugin.getConfig().getInt("failed-transfers." + tID + ".status-code");

                failedTransfers.add(new TransferInfo(playerName, playerUUID, amount, tID, lastTry, retries, statusCode));
            }
        }
    }

    private static void saveFailedTransfer(TransferInfo transferInfo) {
        failedTransfers.add(transferInfo);

        plugin.getConfig().set("failed-transfers." + transferInfo.id() + ".player-name", transferInfo.playerName());
        plugin.getConfig().set("failed-transfers." + transferInfo.id() + ".player-uuid", transferInfo.playerUUID());
        plugin.getConfig().set("failed-transfers." + transferInfo.id() + ".amount", transferInfo.amount());
        plugin.getConfig().set("failed-transfers." + transferInfo.id() + ".last-try", transferInfo.lastTry());
        plugin.getConfig().set("failed-transfers." + transferInfo.id() + ".retries", transferInfo.retries());
        plugin.getConfig().set("failed-transfers." + transferInfo.id() + ".status-code", transferInfo.statusCode());
        plugin.saveConfig();
    }

    private void retryTransfers() {
        LinkedList<TransferInfo> retried = new LinkedList<>();

        for(TransferInfo transfer : failedTransfers) {
            long now = System.currentTimeMillis();

            // If it's been more than 2^retries * 3 seconds since last try failed
            if(now - transfer.lastTry() > Math.pow(2, transfer.retries()) * 3000){
                givePoints(transfer);
                retried.add(transfer);
            }
        }

        if(retried.size() > 0) {
            for(TransferInfo info : retried) {
                plugin.getConfig().set("failed-transfers." + info.id(), null);
            }
            plugin.saveConfig();

            failedTransfers.removeAll(retried);
        }
    }

    private void checkSoftDependencies() {
        try{
            MinecraftReflection.getMinecraftItemStack(new ItemStack(Material.DIRT));
        } catch (NoClassDefFoundError e) {
            canUseReflection = false;
            plugin.getLogger().info("Reflection unavailable; some advancements will be disabled.");
        }
        try{
            Class<Pay4PlayersAPI> test = Pay4PlayersAPI.class;
        } catch (NoClassDefFoundError e) {
            canGivePoints = false;
            plugin.getLogger().info("Pay4PlayersAPI unavailable; point awards will be disabled.");
        }
    }

    private void setCommandExecutors() {
        PluginCommand givePointsCmd = this.getCommand("givepoints");

        if(givePointsCmd != null) givePointsCmd.setExecutor(new GivePointsCommand());
    }

    private void registerAdvancements() {
        advManager.register(new WelcomeMessageAdvancement());
        /**/advManager.register(new B4BreakBlockFailAdvancement());
        /*  */advManager.register(new BreakLogsFreelyAdvancement());
        /*    */advManager.register(new BreakLeavesFreelyAdvancement());
        /*      */advManager.register(new BreakCraftingTableFreelyAdvancement());
        /*        */advManager.register(new BreakBedFreelyAdvancement());
        /*          */advManager.register(new BreakNyliumFreelyAdvancement());
        /*            */advManager.register(new SpreadNyliumAdvancement());
        /*              */advManager.register(new PlaceSlimeSpawnerAdvancement());
        /*          */advManager.register(new BreakAndesiteAdvancement());
        /*    */advManager.register(new PickFlowerAdvancement());
        /*      */advManager.register(new PickAllFlowersAdvancement());
        /*        */advManager.register(new CraftAllDyesAdvancement());
        /*      */advManager.register(new PickupMelonSliceAdvancement());
        /*        */advManager.register(new PickupPumpkinAdvancement());
        /*          */advManager.register(new PickupCactusAdvancement());
        /*      */advManager.register(new KillPolarBearGetIceAdvancement());
        /*        */advManager.register(new KillMooshroomGetStuffAdvancement());
        /*          */advManager.register(new PickupValuableRandomDropAdvancement());
        /*      */advManager.register(new FishGetSpawnEggAdvancement());
        /*        */advManager.register(new FishGetRareStuffAdvancement());
        /*    */advManager.register(new BreakWithinGracePeriodAdvancement());
        /*  */advManager.register(new KillPigGetDirtAdvancement());
        /*    */advManager.register(new B4BreakDirtAdvancement());
        /*    */advManager.register(new RemoveGrassAdvancement());
        /*      */advManager.register(new KillEndermanGetGrassAdvancement());
        /*      */advManager.register(new JumpOnFarmlandAdvancement());
        /*    */advManager.register(new PickupFallingBlockAdvancement());
        /*      */advManager.register(new PickupFlintAdvancement());
        /*        */advManager.register(new HitDripstoneWithTridentAdvancement());
        /*      */advManager.register(new PickupSpawnEggAdvancement());
        /*        */advManager.register(new NameChickenAdvancement());
        /*        */advManager.register(new PickupRareSpawnEggAdvancement());
        /*          */advManager.register(new PickupSuperRareSpawnEggAdvancement());
        /*            */advManager.register(new SpawnZombieHorseAdvancement());
        /*              */advManager.register(new UseAllSpawnEggsAdvancement());
        /*      */advManager.register(new KillRaiderGetClayAdvancement());
        /*    */advManager.register(new HelpCmdAdvancement());
        /*      */advManager.register(new BedCmdAdvancement());
        /*    */advManager.register(new StandCenterOverworldAdvancement());
        /*      */advManager.register(new StandCenterNetherAdvancement());
        /*        */advManager.register(new StandCenterEndAdvancement());
        /*  */advManager.register(new KillZombieGetCharcoalAdvancement());
        /*    */advManager.register(new KillCreeperOrWitchGetRocketAdvancement());
        /*      */advManager.register(new CreeperExplodeGetGunpowderAdvancement());
        /*    */advManager.register(new KillSkeletonGetStoneAdvancement());
        /*      */advManager.register(new KillWitherSkeletonGetBlackstoneAdvancement());
        /*      */advManager.register(new B4BreakStoneAdvancement());
        /*        */advManager.register(new LotsOfCobblestoneAdvancement());
        /*        */advManager.register(new SmeltCobblestoneAdvancement());
        /*        */advManager.register(new PickupSpawnerAdvancement());
        /*          */advManager.register(new PlaceSkeletonSpawnerAdvancement());
        /*            */advManager.register(new LootObsidianAdvancement());
        /*      */advManager.register(new CollectMobHeadAdvancement());
        /*        */advManager.register(new PickupPlayerHeadAdvancement());
        /*          */advManager.register(new DisguiseAdvancement());
        /*        */advManager.register(new CollectAllMobHeadsAdvancement());
        /*          */advManager.register(new PickupAllMobHeadsAdvancement());
        /*      */advManager.register(new KillEndMobGetEndItemAdvancement());

        advManager.register(new B4BreakBlockFailButFreeInClaimAdvancement());
        /**/advManager.register(new PickupSugarCaneAdvancement());
        /*  */advManager.register(new MakePaperAdvancement());
        /*    */advManager.register(new MakeBookAdvancement());
        /*      */advManager.register(new MakeWritableBookAdvancement());
        /*        */advManager.register(new CreateMasterBookAdvancement());
        /*          */advManager.register(new CopyMasterBookAdvancement());
        /*            */advManager.register(new CopyMasterBookCopyAdvancement());
        /*              */advManager.register(new PutMasterBookInEnderChestAdvancement());
        /*      */advManager.register(new MakeLecternAdvancement());
        /*        */advManager.register(new ClaimChunkAdvancement());
        /*          */advManager.register(new BlockBreakInClaimAdvancement());
        /*          */advManager.register(new IntruderAlertAdvancement());
        /*          */advManager.register(new CreateClaimMapAdvancement());
        /*          */advManager.register(new LoseClaimWhileOfflineAdvancement());
        /*          */advManager.register(new ProtectClaimFromAllSidesAdvancement());
        /*            */advManager.register(new ProtectClaimWithGravityBlockAdvancement());
        /*              */advManager.register(new BuildIronGolemAdvancement());
        /*          */advManager.register(new ClaimContestChunkAdvancement());
        /*            */advManager.register(new WinClaimContestAdvancement());
        /*          */advManager.register(new FailBlockPlaceInClaimAdvancement());
        /*            */advManager.register(new RemoveClaimAdvancement());
        /*          */advManager.register(new Claim5ChunksAdvancement());
        /*            */advManager.register(new Claim10ChunksAdvancement());
        /*              */advManager.register(new Claim25ChunksAdvancement());
        /*                */advManager.register(new Claim50ChunksAdvancement());
        /*                  */advManager.register(new Claim100ChunksAdvancement());
        /*                    */advManager.register(new Claim250ChunksAdvancement());
        /*                      */advManager.register(new Claim500ChunksAdvancement());
        /*                        */advManager.register(new Claim1000ChunksAdvancement());
        /*                          */advManager.register(new Claim10000ChunksAdvancement());
        /*                            */advManager.register(new Claim100000ChunksAdvancement());

        advManager.createAll(true);
    }

    private void registerEvents() {
        pluginManager.registerEvents(new B4BlockBreak(), this);
        pluginManager.registerEvents(new B4BlockBreakWithinGracePeriod(), this);
        pluginManager.registerEvents(new BlockBreak(), this);
        pluginManager.registerEvents(new BlockBreakInClaim(), this);
        pluginManager.registerEvents(new BlockPlaceInClaim(), this);
        pluginManager.registerEvents(new ClaimBookPlaced(), this);
        pluginManager.registerEvents(new ClaimRemoved(), this);
        pluginManager.registerEvents(new ClaimMapCreated(), this);
        pluginManager.registerEvents(new ClaimLostWhileOffline(), this);
        pluginManager.registerEvents(new KillEntity(), this);
        pluginManager.registerEvents(new EntityDeath(), this);
        pluginManager.registerEvents(new PickupItem(this), this);
        pluginManager.registerEvents(new FurnaceExtract(), this);
        pluginManager.registerEvents(new BlockPlace(), this);
        pluginManager.registerEvents(new BlockFade(), this);
        pluginManager.registerEvents(new PlayerInteract(this), this);
        pluginManager.registerEvents(new PlayerInteractAtEntity(), this);
        pluginManager.registerEvents(new PlayerMove(), this);
        pluginManager.registerEvents(new PlayerFish(), this);
        pluginManager.registerEvents(new PlayerDisguised(), this);
        pluginManager.registerEvents(new InventoryClick(), this);
        pluginManager.registerEvents(new HelpCmdSucceeded(), this);
        pluginManager.registerEvents(new BedCmdSucceeded(), this);
        pluginManager.registerEvents(new ProjectileHit(), this);
        pluginManager.registerEvents(new CraftItem(), this);
        pluginManager.registerEvents(new MasterBookCreated(), this);
        pluginManager.registerEvents(new IntruderEnteredClaim(), this);
        pluginManager.registerEvents(new CreatureSpawn(), this);
        pluginManager.registerEvents(new ContestChunkClaimed(), this);
        pluginManager.registerEvents(new ClaimContestOver(), this);
        pluginManager.registerEvents(new PlayerClaimsCounted(), this);
        pluginManager.registerEvents(new WelcomeMsgSent(), this);
        pluginManager.registerEvents(new EntityExplode(), this);

        pluginManager.registerEvents(new PlayerAdvancementDone(), this);
    }

    record TransferInfo(String playerName, String playerUUID, int amount, String id, long lastTry, int retries, int statusCode) { }
}
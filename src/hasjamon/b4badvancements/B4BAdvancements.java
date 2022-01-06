package hasjamon.b4badvancements;

import com.comphenix.protocol.utility.MinecraftReflection;
import hasjamon.b4badvancements.advancements.*;
import hasjamon.b4badvancements.listeners.*;
import net.minecraft.locale.LocaleLanguage;
import net.roxeez.advancement.AdvancementManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class B4BAdvancements extends JavaPlugin implements Listener {
    public static boolean canUseReflection = true;
    private static B4BAdvancements plugin;
    private final PluginManager pluginManager = getServer().getPluginManager();
    private final AdvancementManager advManager = new AdvancementManager(this);

    @Override
    public void onEnable(){
        plugin = this;
        checkSoftDependencies();
        registerAdvancements();
        registerEvents();
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
            return LocaleLanguage.a().a(((net.minecraft.world.item.ItemStack) refItemStack).getName().getString());
        } catch (ClassCastException e) {
            e.printStackTrace();
            return "";
        }
    }

    private void checkSoftDependencies() {
        try{
            MinecraftReflection.getMinecraftItemStack(new ItemStack(Material.DIRT));
        } catch (NoClassDefFoundError e) {
            canUseReflection = false;
            plugin.getLogger().info("Reflection unavailable; some advancements will be disabled.");
        }
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
        /*  */advManager.register(new KillSkeletonGetStoneAdvancement());
        /*    */advManager.register(new KillWitherSkeletonGetBlackstoneAdvancement());
        /*    */advManager.register(new B4BreakStoneAdvancement());
        /*      */advManager.register(new LotsOfCobblestoneAdvancement());
        /*      */advManager.register(new SmeltCobblestoneAdvancement());
        /*      */advManager.register(new PickupSpawnerAdvancement());
        /*        */advManager.register(new PlaceSkeletonSpawnerAdvancement());
        /*          */advManager.register(new LootObsidianAdvancement());
        /*    */advManager.register(new CollectMobHeadAdvancement());
        /*      */advManager.register(new PickupPlayerHeadAdvancement());
        /*        */advManager.register(new DisguiseAdvancement());
        /*      */advManager.register(new CollectAllMobHeadsAdvancement());
        /*        */advManager.register(new PickupAllMobHeadsAdvancement());
        /*    */advManager.register(new KillEndMobGetEndItemAdvancement());

        advManager.register(new PickupSugarCaneAdvancement());
        /**/advManager.register(new MakePaperAdvancement());
        /*  */advManager.register(new MakeBookAdvancement());
        /*    */advManager.register(new MakeWritableBookAdvancement());
        /*      */advManager.register(new CreateMasterBookAdvancement());
        /*        */advManager.register(new CopyMasterBookAdvancement());
        /*          */advManager.register(new CopyMasterBookCopyAdvancement());
        /*            */advManager.register(new PutMasterBookInEnderChestAdvancement());
        /*    */advManager.register(new MakeLecternAdvancement());
        /*      */advManager.register(new ClaimChunkAdvancement());
        /*        */advManager.register(new BlockBreakInClaimAdvancement());
        /*        */advManager.register(new IntruderAlertAdvancement());
        /*        */advManager.register(new CreateClaimMapAdvancement());
        /*        */advManager.register(new LoseClaimWhileOfflineAdvancement());
        /*        */advManager.register(new BuildIronGolemAdvancement());
        /*        */advManager.register(new ClaimContestChunkAdvancement());
        /*          */advManager.register(new WinClaimContestAdvancement());
        /*        */advManager.register(new FailBlockPlaceInClaimAdvancement());
        /*          */advManager.register(new RemoveClaimAdvancement());
        /*        */advManager.register(new Claim5ChunksAdvancement());
        /*          */advManager.register(new Claim10ChunksAdvancement());
        /*            */advManager.register(new Claim25ChunksAdvancement());
        /*              */advManager.register(new Claim50ChunksAdvancement());
        /*                */advManager.register(new Claim100ChunksAdvancement());
        /*                  */advManager.register(new Claim250ChunksAdvancement());
        /*                    */advManager.register(new Claim500ChunksAdvancement());
        /*                      */advManager.register(new Claim1000ChunksAdvancement());
        /*                        */advManager.register(new Claim10000ChunksAdvancement());
        /*                          */advManager.register(new Claim100000ChunksAdvancement());

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
    }
}

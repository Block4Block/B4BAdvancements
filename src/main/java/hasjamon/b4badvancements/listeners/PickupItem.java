package hasjamon.b4badvancements.listeners;

import com.google.common.collect.Sets;
import hasjamon.b4badvancements.B4BAdvancements;
import hasjamon.b4badvancements.advancements.*;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PickupItem implements Listener {
    public static final HashSet<Material> valuableDrops = Sets.newHashSet(
            Material.DIAMOND_BLOCK, Material.NETHERITE_BLOCK, Material.EMERALD_BLOCK, Material.GOLD_BLOCK,
            Material.ENCHANTING_TABLE, Material.OBSIDIAN, Material.CRYING_OBSIDIAN, Material.RESPAWN_ANCHOR,
            Material.ENDER_CHEST, Material.SHULKER_BOX, Material.BLACK_SHULKER_BOX, Material.BLUE_SHULKER_BOX,
            Material.BROWN_SHULKER_BOX, Material.CYAN_SHULKER_BOX, Material.GRAY_SHULKER_BOX,
            Material.GREEN_SHULKER_BOX, Material.LIGHT_BLUE_SHULKER_BOX, Material.LIGHT_GRAY_SHULKER_BOX,
            Material.LIME_SHULKER_BOX, Material.MAGENTA_SHULKER_BOX, Material.ORANGE_SHULKER_BOX,
            Material.PINK_SHULKER_BOX, Material.PURPLE_SHULKER_BOX, Material.RED_SHULKER_BOX,
            Material.WHITE_SHULKER_BOX, Material.YELLOW_SHULKER_BOX, Material.SHULKER_BOX);
    public static final HashSet<Material> flowers = Sets.newHashSet(
            Material.DANDELION, Material.POPPY, Material.BLUE_ORCHID, Material.ALLIUM,
            Material.AZURE_BLUET, Material.RED_TULIP, Material.ORANGE_TULIP,
            Material.WHITE_TULIP, Material.PINK_TULIP, Material.OXEYE_DAISY,
            Material.CORNFLOWER, Material.LILY_OF_THE_VALLEY, Material.WITHER_ROSE,
            Material.SUNFLOWER, Material.LILAC, Material.ROSE_BUSH, Material.PEONY);
    public static final List<String> mobHeads = Arrays.asList(
            "Creamy Trader Llama", "White Trader Llama", "Brown Trader Llama", "Gray Trader Llama", "Slime", "Chicken",
            "Guardian", "Enderman", "Goat", "Screaming Goat", "Ghast", "Cod", "Blaze", "Pufferfish", "Witch",
            "Iron Golem", "Wolf", "Angry Wolf", "Evoker", "Polar Bear", "Pig", "Vex", "Tabby Cat", "Tuxedo Cat",
            "Ginger Cat", "Siamese Cat", "British Shorthair Cat", "Calico Cat", "Persian Cat", "Ragdoll Cat",
            "White Cat", "Jellie Cat", "Black Cat", "Wandering Trader", "Silverfish", "Aggressive Panda", "Lazy Panda",
            "Playful Panda", "Worried Panda", "Brown Panda", "Weak Panda", "Panda", "Phantom", "Donkey", "Creamy Llama",
            "White Llama", "Brown Llama", "Gray Llama", "Ocelot", "Glow Squid", "Shulker", "White Horse",
            "Creamy Horse", "Chestnut Horse", "Brown Horse", "Black Horse", "Gray Horse", "Dark Brown Horse",
            "Tropical Fish", "Strider", "Freezing Strider", "Magma Cube", "Skeleton Horse", "Zombie Horse", "Turtle",
            "Vindicator", "Husk", "Bee", "Pollinated Bee", "Angry Bee", "Angry Pollinated Bee", "Squid", "Cave Spider",
            "Red Parrot", "Blue Parrot", "Green Parrot", "Light Blue Parrot", "Gray Parrot", "Ravager", "Hoglin",
            "Salmon", "Fox", "Snow Fox", "Red Mooshroom", "Brown Mooshroom", "Zombie ", "Zombie Butcher",
            "Zombie Cartographer", "Zombie Cleric", "Zombie Farmer", "Zombie Fisherman", "Zombie ",
            "Zombie Leatherworker", "Zombie Librarian", "Zombie Mason", "Zombie Nitwit", "Zombie Villager",
            "Zombie Shepherd", "Zombie Toolsmith", "Zombie Weaponsmith", "Zoglin", "Toast", "Brown Rabbit",
            "White Rabbit", "Black Rabbit", "Black and White Rabbit", "Gold Rabbit", "Salt and Pepper Rabbit",
            "Bat", "Piglin Brute", "Dolphin", "Charged Creeper", "Zombified Piglin", "Endermite",
            "Lucy Axolotl", "Wild Axolotl", "Gold Axolotl", "Cyan Axolotl", "Blue Axolotl", "Mule", "Spider",
            "Elder Guardian", "Stray", "Drowned", "Wither", "Invulnerable Wither", "Armored Wither",
            "Armored Invulnerable Wither", "Cow", "Pillager", "jeb_ Sheep", "Orange Sheep", "Brown Sheep",
            "Green Sheep", "Lime Sheep", "Red Sheep", "Yellow Sheep", "White Sheep", "Pink Sheep", "Gray Sheep",
            "Light Blue Sheep", "Cyan Sheep", "Light Gray Sheep", "Purple Sheep", "Magenta Sheep", "Black Sheep",
            "Blue Sheep", "Armorer Villager", "Butcher Villager", "Cartographer Villager", "Cleric Villager",
            "Farmer Villager", "Fisherman Villager", "Fletcher Villager", "Leatherworker Villager",
            "Librarian Villager", "Mason Villager", "Nitwit Villager", "Unemployed Villager", "Shepherd Villager",
            "Toolsmith Villager", "Weaponsmith Villager", "Piglin", "Snow Golem",
            "Allay", "Cold Frog", "Temperate Frog", "Warm Frog", "Tadpole", "Warden");
    private final B4BAdvancements plugin;

    public PickupItem(B4BAdvancements plugin){
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPickupItem(EntityPickupItemEvent e) {
        Item item = e.getItem();
        ItemStack itemStack = item.getItemStack();

        if (e.getEntityType() == EntityType.PLAYER) {
            boolean isNewDrop = checkIfNew(itemStack);
            Player player = (Player) e.getEntity();
            Material itemType = itemStack.getType();

            if(isNewDrop && valuableDrops.contains(itemType)){
                B4BAdvancements.awardCriteria(player, PickupValuableRandomDropAdvancement.ID, "0");
            }

            if(flowers.contains(itemType)){
                B4BAdvancements.awardCriteria(player, PickFlowerAdvancement.ID, "0");
                B4BAdvancements.awardCriteria(player, PickAllFlowersAdvancement.ID, itemType.toString());
            }

            switch(itemType){
                case STONE -> {
                    if (System.nanoTime() - KillEntity.lastSkeletonKill.getOrDefault(player, 0L) <= 3e10) {
                        B4BAdvancements.awardCriteria(player, KillSkeletonGetStoneAdvancement.ID, "0");
                    }
                }
                case BLACKSTONE, GILDED_BLACKSTONE -> {
                    if (System.nanoTime() - KillEntity.lastWitherSkeletonKill.getOrDefault(player, 0L) <= 3e10) {
                        B4BAdvancements.awardCriteria(player, KillWitherSkeletonGetBlackstoneAdvancement.ID, "0");
                    }
                }
                case DIRT -> {
                    if (System.nanoTime() - KillEntity.lastPigKill.getOrDefault(player, 0L) <= 3e10) {
                        B4BAdvancements.awardCriteria(player, KillPigGetDirtAdvancement.ID, "0");
                    }
                }
                case GRASS_BLOCK -> {
                    if (System.nanoTime() - KillEntity.lastEndermanKill.getOrDefault(player, 0L) <= 3e10) {
                        B4BAdvancements.awardCriteria(player, KillEndermanGetGrassAdvancement.ID, "0");
                    }
                }
                case CRIMSON_STEM, CRIMSON_HYPHAE, NETHER_WART_BLOCK, CRIMSON_FUNGUS, WARPED_STEM, WARPED_HYPHAE,
                        WARPED_WART_BLOCK, BROWN_MUSHROOM_BLOCK, RED_MUSHROOM_BLOCK, MUSHROOM_STEM, BROWN_MUSHROOM,
                        RED_MUSHROOM, MYCELIUM -> {
                    if (System.nanoTime() - KillEntity.lastMooshroomKill.getOrDefault(player, 0L) <= 3e10) {
                        B4BAdvancements.awardCriteria(player, KillMooshroomGetStuffAdvancement.ID, "0");
                    }
                }
                case ICE -> {
                    if (System.nanoTime() - KillEntity.lastPolarBearKill.getOrDefault(player, 0L) <= 3e10) {
                        B4BAdvancements.awardCriteria(player, KillPolarBearGetIceAdvancement.ID, "0");
                    }
                }
                case CLAY -> {
                    if (System.nanoTime() - KillEntity.lastRaiderKill.getOrDefault(player, 0L) <= 3e10) {
                        B4BAdvancements.awardCriteria(player, KillRaiderGetClayAdvancement.ID, "0");
                    }
                }
                case END_STONE, END_ROD -> {
                    if (System.nanoTime() - KillEntity.lastEndMobKill.getOrDefault(player, 0L) <= 3e10) {
                        B4BAdvancements.awardCriteria(player, KillEndMobGetEndItemAdvancement.ID, "0");
                    }
                }
                case COBBLESTONE -> {
                    List<Material> diamondOrNetherite = Arrays.asList(Material.DIAMOND_PICKAXE, Material.NETHERITE_PICKAXE);
                    ItemStack mainhandItem = player.getInventory().getItemInMainHand();

                    if (diamondOrNetherite.contains(mainhandItem.getType())) {
                        Bukkit.getScheduler().runTaskLater(plugin, () -> {
                            int slotsFullOfCobblestone = 0;

                            for (ItemStack invItem : player.getInventory().getContents()) {
                                if (invItem != null) {
                                    if (invItem.getType() == Material.COBBLESTONE && invItem.getAmount() == 64) {
                                        slotsFullOfCobblestone++;
                                    }
                                }
                            }

                            if (slotsFullOfCobblestone >= 5) {
                                B4BAdvancements.awardCriteria(player, LotsOfCobblestoneAdvancement.ID, "0");
                            }
                        }, 1);
                    }
                }
                case SPAWNER -> {
                    B4BAdvancements.awardCriteria(player, PickupSpawnerAdvancement.ID, "0");
                }
                case SAND, RED_SAND, GRAVEL, ANVIL, CHIPPED_ANVIL, DAMAGED_ANVIL, BLACK_CONCRETE_POWDER,
                        BROWN_CONCRETE_POWDER, BLUE_CONCRETE_POWDER, CYAN_CONCRETE_POWDER, GRAY_CONCRETE_POWDER,
                        GREEN_CONCRETE_POWDER, LIGHT_BLUE_CONCRETE_POWDER, LIGHT_GRAY_CONCRETE_POWDER,
                        LIME_CONCRETE_POWDER, MAGENTA_CONCRETE_POWDER, ORANGE_CONCRETE_POWDER, PINK_CONCRETE_POWDER,
                        PURPLE_CONCRETE_POWDER, RED_CONCRETE_POWDER, WHITE_CONCRETE_POWDER, YELLOW_CONCRETE_POWDER,
                        DRAGON_EGG, SCAFFOLDING, POINTED_DRIPSTONE -> {
                    B4BAdvancements.awardCriteria(player, PickupFallingBlockAdvancement.ID, "0");
                }
                case FLINT -> {
                    B4BAdvancements.awardCriteria(player, PickupFlintAdvancement.ID, "0");
                }
                case SPIDER_SPAWN_EGG, BAT_SPAWN_EGG, BEE_SPAWN_EGG, CAT_SPAWN_EGG, CAVE_SPIDER_SPAWN_EGG,
                        COD_SPAWN_EGG, COW_SPAWN_EGG, CREEPER_SPAWN_EGG, DOLPHIN_SPAWN_EGG, DONKEY_SPAWN_EGG,
                        DROWNED_SPAWN_EGG, ENDERMITE_SPAWN_EGG, FOX_SPAWN_EGG, GOAT_SPAWN_EGG, GLOW_SQUID_SPAWN_EGG,
                        FROG_SPAWN_EGG, TADPOLE_SPAWN_EGG,
                        HORSE_SPAWN_EGG, HUSK_SPAWN_EGG, LLAMA_SPAWN_EGG, MULE_SPAWN_EGG, OCELOT_SPAWN_EGG,
                        PANDA_SPAWN_EGG, PARROT_SPAWN_EGG, PHANTOM_SPAWN_EGG, PIG_SPAWN_EGG, PILLAGER_SPAWN_EGG,
                        ALLAY_SPAWN_EGG,
                        POLAR_BEAR_SPAWN_EGG, PUFFERFISH_SPAWN_EGG, RABBIT_SPAWN_EGG, SALMON_SPAWN_EGG, SHEEP_SPAWN_EGG,
                        SILVERFISH_SPAWN_EGG, SKELETON_SPAWN_EGG, SQUID_SPAWN_EGG, TRADER_LLAMA_SPAWN_EGG,
                        TURTLE_SPAWN_EGG, TROPICAL_FISH_SPAWN_EGG, WOLF_SPAWN_EGG, ZOMBIE_SPAWN_EGG -> {
                    B4BAdvancements.awardCriteria(player, PickupSpawnEggAdvancement.ID, "0");
                }
                case STRIDER_SPAWN_EGG, SLIME_SPAWN_EGG, WANDERING_TRADER_SPAWN_EGG, AXOLOTL_SPAWN_EGG,
                        ZOMBIFIED_PIGLIN_SPAWN_EGG, VEX_SPAWN_EGG, WITCH_SPAWN_EGG, VINDICATOR_SPAWN_EGG,
                        STRAY_SPAWN_EGG, GUARDIAN_SPAWN_EGG, ENDERMAN_SPAWN_EGG, PIGLIN_SPAWN_EGG,
                        PIGLIN_BRUTE_SPAWN_EGG, ZOGLIN_SPAWN_EGG, HOGLIN_SPAWN_EGG, MAGMA_CUBE_SPAWN_EGG,
                        BLAZE_SPAWN_EGG, RAVAGER_SPAWN_EGG, WITHER_SKELETON_SPAWN_EGG, SHULKER_SPAWN_EGG,
                        EVOKER_SPAWN_EGG, SKELETON_HORSE_SPAWN_EGG, VILLAGER_SPAWN_EGG, ZOMBIE_VILLAGER_SPAWN_EGG -> {
                    B4BAdvancements.awardCriteria(player, PickupSpawnEggAdvancement.ID, "0");
                    B4BAdvancements.awardCriteria(player, PickupRareSpawnEggAdvancement.ID, "0");
                }
                case MOOSHROOM_SPAWN_EGG, ELDER_GUARDIAN_SPAWN_EGG, GHAST_SPAWN_EGG, WARDEN_SPAWN_EGG,
                        CHICKEN_SPAWN_EGG, ZOMBIE_HORSE_SPAWN_EGG -> {
                    B4BAdvancements.awardCriteria(player, PickupSpawnEggAdvancement.ID, "0");
                    B4BAdvancements.awardCriteria(player, PickupRareSpawnEggAdvancement.ID, "0");
                    B4BAdvancements.awardCriteria(player, PickupSuperRareSpawnEggAdvancement.ID, "0");
                }
                case PLAYER_HEAD -> {
                    ItemMeta meta = itemStack.getItemMeta();

                    if(meta != null) {
                        SkullMeta skullMeta = (SkullMeta) meta;
                        OfflinePlayer headOwner = skullMeta.getOwningPlayer();

                        // If it's a player head (i.e., not from a mob)
                        if (headOwner != null && headOwner.getFirstPlayed() > 0) {
                            OfflinePlayer skullOwner = skullMeta.getOwningPlayer();

                            if (!skullOwner.getUniqueId().equals(player.getUniqueId())) {
                                B4BAdvancements.awardCriteria(player, PickupPlayerHeadAdvancement.ID, "0");
                            }
                        }else{
                            B4BAdvancements.awardCriteria(player, CollectMobHeadAdvancement.ID, "0");

                            if (skullMeta.getLore() != null) {
                                List<String> lore = skullMeta.getLore();
                                String loreText = lore.get(0);

                                if (mobHeads.contains(loreText)) {
                                    B4BAdvancements.awardCriteria(player, CollectAllMobHeadsAdvancement.ID, loreText);
                                    if(isNewDrop){
                                        B4BAdvancements.awardCriteria(player, PickupAllMobHeadsAdvancement.ID, loreText);
                                    }
                                }
                            }
                        }
                    }
                }
                case SKELETON_SKULL, WITHER_SKELETON_SKULL, CREEPER_HEAD, DRAGON_HEAD, ZOMBIE_HEAD -> {
                    B4BAdvancements.awardCriteria(player, CollectMobHeadAdvancement.ID, "0");
                    B4BAdvancements.awardCriteria(player, CollectAllMobHeadsAdvancement.ID, itemType.toString());
                    if(isNewDrop){
                        B4BAdvancements.awardCriteria(player, PickupAllMobHeadsAdvancement.ID, itemType.toString());
                    }
                }
                case MELON_SLICE -> {
                    B4BAdvancements.awardCriteria(player, PickupMelonSliceAdvancement.ID, "0");
                }
                case CACTUS -> {
                    B4BAdvancements.awardCriteria(player, PickupCactusAdvancement.ID, "0");
                }
                case PUMPKIN, CARVED_PUMPKIN -> {
                    B4BAdvancements.awardCriteria(player, PickupPumpkinAdvancement.ID, "0");
                }
                case SUGAR_CANE -> {
                    B4BAdvancements.awardCriteria(player, PickupSugarCaneAdvancement.ID, "0");
                }
            }
        }
    }

    public static boolean checkIfNew(ItemStack itemStack) {
        ItemMeta meta = itemStack.getItemMeta();

        if (meta != null && meta.getLore() != null) {
            List<String> lore = meta.getLore();
            String prefix = EntityDeath.NEW_DROP_PREFIX;

            if(lore.get(0).startsWith(prefix)) {
                lore.set(0, lore.get(0).substring(prefix.length()));
                meta.setLore(lore);
                itemStack.setItemMeta(meta);

                return true;
            }
        }

        return false;
    }
}

package hasjamon.b4badvancements.listeners;

import hasjamon.b4badvancements.B4BAdvancements;
import hasjamon.b4badvancements.advancements.*;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;

public class InventoryClick implements Listener {
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onInventoryClickEvent(InventoryClickEvent e) {
        ItemStack itemInSlot = e.getCurrentItem();
        ItemStack itemOnCursor = e.getCursor();
        Inventory invClicked = e.getClickedInventory();

        if(itemInSlot != null && invClicked != null && e.getWhoClicked() instanceof Player player) {
            if(itemInSlot.getType() == Material.WRITTEN_BOOK){
                if(e.getClick().isShiftClick() && invClicked.getType() == InventoryType.PLAYER &&
                        player.getOpenInventory().getType() == InventoryType.ENDER_CHEST &&
                        isOriginal((BookMeta) itemInSlot.getItemMeta())) {
                    B4BAdvancements.awardCriteria(player, PutMasterBookInEnderChestAdvancement.ID, "0");
                }
            }else{
                Material itemType = itemInSlot.getType();
                List<String> advIDs = new ArrayList<>();
                boolean isNew = PickupItem.checkIfNew(itemInSlot);

                if(isNew && PickupItem.valuableDrops.contains(itemType)){
                    advIDs.add(PickupValuableRandomDropAdvancement.ID);
                }

                switch (itemType) {
                    case OBSIDIAN -> advIDs.add(LootObsidianAdvancement.ID);
                    case MELON_SLICE -> advIDs.add(PickupMelonSliceAdvancement.ID);
                    case CACTUS -> advIDs.add(PickupCactusAdvancement.ID);
                    case PUMPKIN, CARVED_PUMPKIN -> advIDs.add(PickupPumpkinAdvancement.ID);
                    case SUGAR_CANE -> advIDs.add(PickupSugarCaneAdvancement.ID);
                    case SPIDER_SPAWN_EGG, BAT_SPAWN_EGG, BEE_SPAWN_EGG, CAT_SPAWN_EGG, CAVE_SPIDER_SPAWN_EGG,
                            COD_SPAWN_EGG, COW_SPAWN_EGG, CREEPER_SPAWN_EGG, DOLPHIN_SPAWN_EGG, DONKEY_SPAWN_EGG,
                            DROWNED_SPAWN_EGG, ENDERMITE_SPAWN_EGG, FOX_SPAWN_EGG, GOAT_SPAWN_EGG, GLOW_SQUID_SPAWN_EGG,
                            HORSE_SPAWN_EGG, HUSK_SPAWN_EGG, LLAMA_SPAWN_EGG, MULE_SPAWN_EGG, OCELOT_SPAWN_EGG,
                            PANDA_SPAWN_EGG, PARROT_SPAWN_EGG, PHANTOM_SPAWN_EGG, PIG_SPAWN_EGG, PILLAGER_SPAWN_EGG,
                            POLAR_BEAR_SPAWN_EGG, PUFFERFISH_SPAWN_EGG, RABBIT_SPAWN_EGG, SALMON_SPAWN_EGG, SHEEP_SPAWN_EGG,
                            SILVERFISH_SPAWN_EGG, SKELETON_SPAWN_EGG, SQUID_SPAWN_EGG, TRADER_LLAMA_SPAWN_EGG,
                            TURTLE_SPAWN_EGG, TROPICAL_FISH_SPAWN_EGG, WOLF_SPAWN_EGG, ZOMBIE_SPAWN_EGG -> {
                        advIDs.add(PickupSpawnEggAdvancement.ID);
                    }
                    case STRIDER_SPAWN_EGG, SLIME_SPAWN_EGG, WANDERING_TRADER_SPAWN_EGG, AXOLOTL_SPAWN_EGG,
                            ZOMBIFIED_PIGLIN_SPAWN_EGG, VEX_SPAWN_EGG, WITCH_SPAWN_EGG, VINDICATOR_SPAWN_EGG,
                            STRAY_SPAWN_EGG, GUARDIAN_SPAWN_EGG, ENDERMAN_SPAWN_EGG, PIGLIN_SPAWN_EGG,
                            PIGLIN_BRUTE_SPAWN_EGG, ZOGLIN_SPAWN_EGG, HOGLIN_SPAWN_EGG, MAGMA_CUBE_SPAWN_EGG,
                            BLAZE_SPAWN_EGG, RAVAGER_SPAWN_EGG, WITHER_SKELETON_SPAWN_EGG, SHULKER_SPAWN_EGG,
                            EVOKER_SPAWN_EGG, SKELETON_HORSE_SPAWN_EGG, VILLAGER_SPAWN_EGG, ZOMBIE_VILLAGER_SPAWN_EGG -> {
                        advIDs.add(PickupSpawnEggAdvancement.ID);
                        advIDs.add(PickupRareSpawnEggAdvancement.ID);
                    }
                    case MOOSHROOM_SPAWN_EGG, ELDER_GUARDIAN_SPAWN_EGG, GHAST_SPAWN_EGG, CHICKEN_SPAWN_EGG,
                            ZOMBIE_HORSE_SPAWN_EGG -> {
                        advIDs.add(PickupSpawnEggAdvancement.ID);
                        advIDs.add(PickupRareSpawnEggAdvancement.ID);
                        advIDs.add(PickupSuperRareSpawnEggAdvancement.ID);
                    }
                    case PLAYER_HEAD -> {
                        ItemMeta meta = itemInSlot.getItemMeta();

                        if(meta != null) {
                            SkullMeta skullMeta = (SkullMeta) meta;
                            OfflinePlayer headOwner = skullMeta.getOwningPlayer();

                            // If it's a player head (i.e., not from a mob)
                            if (headOwner != null && headOwner.getFirstPlayed() > 0) {
                                OfflinePlayer skullOwner = skullMeta.getOwningPlayer();

                                if (!skullOwner.getUniqueId().equals(player.getUniqueId())) {
                                    advIDs.add(PickupPlayerHeadAdvancement.ID);
                                }
                            }else{
                                advIDs.add(CollectMobHeadAdvancement.ID);

                                if (skullMeta.getLore() != null) {
                                    List<String> lore = skullMeta.getLore();
                                    String loreText = lore.get(0);

                                    if (PickupItem.mobHeads.contains(loreText)) {
                                        B4BAdvancements.awardCriteria(player, CollectAllMobHeadsAdvancement.ID, loreText);
                                        if(isNew){
                                            B4BAdvancements.awardCriteria(player, PickupAllMobHeadsAdvancement.ID, loreText);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    case SKELETON_SKULL, WITHER_SKELETON_SKULL, CREEPER_HEAD, DRAGON_HEAD, ZOMBIE_HEAD -> {
                        advIDs.add(CollectMobHeadAdvancement.ID);
                        B4BAdvancements.awardCriteria(player, CollectAllMobHeadsAdvancement.ID, itemType.toString());
                        if(isNew){
                            B4BAdvancements.awardCriteria(player, PickupAllMobHeadsAdvancement.ID, itemType.toString());
                        }
                    }
                }

                for(String advID : advIDs){
                    B4BAdvancements.awardCriteria(player, advID, "0");
                }
            }

            if(itemOnCursor != null) {
                if (itemOnCursor.getType() == Material.WRITTEN_BOOK &&
                        e.getClick().isLeftClick() && invClicked.getType() == InventoryType.ENDER_CHEST &&
                        isOriginal((BookMeta) itemOnCursor.getItemMeta())) {
                    B4BAdvancements.awardCriteria(player, PutMasterBookInEnderChestAdvancement.ID, "0");
                }
            }
        }
    }

    private boolean isOriginal(BookMeta meta){
        // meta is bugged (hasGeneration() is only true for copies)
        return meta != null && !meta.hasGeneration();
    }
}
package hasjamon.b4badvancements.listeners;

import hasjamon.b4badvancements.B4BAdvancements;
import hasjamon.b4badvancements.advancements.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class BlockBreak implements Listener {
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onBlockBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();

        switch(e.getBlock().getType()){
            case ACACIA_LOG, BIRCH_LOG, DARK_OAK_LOG, JUNGLE_LOG, OAK_LOG, SPRUCE_LOG, AZALEA -> {
                B4BAdvancements.awardCriteria(player, BreakLogsFreelyAdvancement.ID, "0");
            }
            case ACACIA_LEAVES, BIRCH_LEAVES, DARK_OAK_LEAVES, JUNGLE_LEAVES, OAK_LEAVES, SPRUCE_LEAVES,
                    AZALEA_LEAVES -> {
                B4BAdvancements.awardCriteria(player, BreakLeavesFreelyAdvancement.ID, "0");
            }
            case CRAFTING_TABLE -> {
                B4BAdvancements.awardCriteria(player, BreakCraftingTableFreelyAdvancement.ID, "0");
            }
            case BLACK_BED, BLUE_BED, BROWN_BED, CYAN_BED, LIGHT_BLUE_BED, LIGHT_GRAY_BED, GRAY_BED, GREEN_BED,
                    LIME_BED, MAGENTA_BED, ORANGE_BED, PINK_BED, PURPLE_BED, RED_BED, WHITE_BED, YELLOW_BED -> {
                B4BAdvancements.awardCriteria(player, BreakBedFreelyAdvancement.ID, "0");
            }
            case CRIMSON_NYLIUM, WARPED_NYLIUM -> {
                ItemStack mainhandItem = player.getInventory().getItemInMainHand();

                B4BAdvancements.awardCriteria(player, BreakNyliumFreelyAdvancement.ID, "0");
                /*
                if(mainhandItem.containsEnchantment(Enchantment.SILK_TOUCH) && (
                        mainhandItem.getType() == Material.WOODEN_PICKAXE ||
                        mainhandItem.getType() == Material.IRON_PICKAXE ||
                        mainhandItem.getType() == Material.STONE_PICKAXE ||
                        mainhandItem.getType() == Material.GOLDEN_PICKAXE ||
                        mainhandItem.getType() == Material.DIAMOND_PICKAXE ||
                        mainhandItem.getType() == Material.NETHERITE_PICKAXE
                )){
                    B4BAdvancements.awardCriteria(player, BreakNyliumWithSilkTouchAdvancement.ID, "0");
                }*/
            }
        }
    }
}
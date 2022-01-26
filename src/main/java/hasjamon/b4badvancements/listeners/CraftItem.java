package hasjamon.b4badvancements.listeners;

import com.google.common.collect.Sets;
import hasjamon.b4badvancements.B4BAdvancements;
import hasjamon.b4badvancements.advancements.*;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.HashSet;

public class CraftItem implements Listener {
    public static final HashSet<Material> craftableDyes = Sets.newHashSet(
            Material.BLACK_DYE, Material.BLUE_DYE, Material.BROWN_DYE, Material.CYAN_DYE, Material.GRAY_DYE,
            Material.LIGHT_BLUE_DYE, Material.LIGHT_GRAY_DYE, Material.LIME_DYE, Material.MAGENTA_DYE,
            Material.ORANGE_DYE, Material.PINK_DYE, Material.PURPLE_DYE, Material.RED_DYE, Material.WHITE_DYE,
            Material.YELLOW_DYE);

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onCraftItem(CraftItemEvent e) {
        if(e.getWhoClicked() instanceof Player player) {
            ItemStack result = e.getInventory().getResult();

            if(result != null) {
                Material itemType = result.getType();

                switch (itemType) {
                    case PAPER -> {
                        B4BAdvancements.awardCriteria(player, MakePaperAdvancement.ID, "0");
                    }
                    case BOOK -> {
                        B4BAdvancements.awardCriteria(player, MakeBookAdvancement.ID, "0");
                    }
                    case WRITABLE_BOOK -> {
                        B4BAdvancements.awardCriteria(player, MakeWritableBookAdvancement.ID, "0");
                    }
                    case LECTERN -> {
                        B4BAdvancements.awardCriteria(player, MakeLecternAdvancement.ID, "0");
                    }
                    case WRITTEN_BOOK -> {
                        BookMeta meta = (BookMeta) result.getItemMeta();

                        if (meta != null && meta.hasGeneration()) {
                            if (meta.getGeneration() == BookMeta.Generation.COPY_OF_ORIGINAL) {
                                B4BAdvancements.awardCriteria(player, CopyMasterBookAdvancement.ID, "0");
                            } else if (meta.getGeneration() == BookMeta.Generation.COPY_OF_COPY) {
                                B4BAdvancements.awardCriteria(player, CopyMasterBookCopyAdvancement.ID, "0");
                            }
                        }
                    }
                    case BLACK_DYE, BLUE_DYE, BROWN_DYE, CYAN_DYE, GRAY_DYE, LIGHT_BLUE_DYE, LIGHT_GRAY_DYE, LIME_DYE,
                            MAGENTA_DYE, ORANGE_DYE, PINK_DYE, PURPLE_DYE, RED_DYE, WHITE_DYE, YELLOW_DYE -> {
                        B4BAdvancements.awardCriteria(player, CraftAllDyesAdvancement.ID, itemType.toString());
                    }
                }
            }
        }
    }
}
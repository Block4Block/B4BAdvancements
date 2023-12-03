package hasjamon.b4badvancements.listeners;

import hasjamon.b4badvancements.B4BAdvancements;
import hasjamon.b4badvancements.advancements.SmeltCobblestoneAdvancement;
import hasjamon.b4badvancements.advancements.UseNewBlastFurnaceRecipeAdvancement;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceExtractEvent;

public class FurnaceExtract implements Listener {
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onFurnaceExtract(FurnaceExtractEvent e) {
        Material extractedItem = e.getItemType();

        switch (extractedItem) {
            case STONE:
                B4BAdvancements.awardCriteria(e.getPlayer(), SmeltCobblestoneAdvancement.ID, "0");
                // No break
            case DEEPSLATE:
                Material furnaceType = e.getBlock().getType();
                if (furnaceType == Material.BLAST_FURNACE)
                    B4BAdvancements.awardCriteria(e.getPlayer(), UseNewBlastFurnaceRecipeAdvancement.ID, "0");

        }
    }
}
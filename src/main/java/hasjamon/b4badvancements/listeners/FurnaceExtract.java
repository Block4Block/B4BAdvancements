package hasjamon.b4badvancements.listeners;

import hasjamon.b4badvancements.B4BAdvancements;
import hasjamon.b4badvancements.advancements.SmeltCobblestoneAdvancement;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceExtractEvent;

public class FurnaceExtract implements Listener {
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onFurnaceExtract(FurnaceExtractEvent e) {
        if(e.getItemType() == Material.STONE) {
            B4BAdvancements.awardCriteria(e.getPlayer(), SmeltCobblestoneAdvancement.ID, "0");
        }
    }
}
package hasjamon.b4badvancements.listeners;

import hasjamon.b4badvancements.B4BAdvancements;
import hasjamon.b4badvancements.advancements.BedCmdAdvancement;
import hasjamon.block4block.events.BedCmdSucceededEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class BedCmdSucceeded implements Listener {
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onBedCmdSucceded(BedCmdSucceededEvent e) {
        B4BAdvancements.awardCriteria(e.player, BedCmdAdvancement.ID, "0");
    }
}

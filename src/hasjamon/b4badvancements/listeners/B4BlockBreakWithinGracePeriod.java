package hasjamon.b4badvancements.listeners;

import hasjamon.b4badvancements.B4BAdvancements;
import hasjamon.b4badvancements.advancements.BreakWithinGracePeriodAdvancement;
import hasjamon.block4block.events.B4BlockBreakWithinGracePeriodEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class B4BlockBreakWithinGracePeriod implements Listener {
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onB4BlockBreakWithinGracePeriod(B4BlockBreakWithinGracePeriodEvent e) {
        if(e.normallyRequiresBlock) {
            B4BAdvancements.awardCriteria(e.player, BreakWithinGracePeriodAdvancement.ID, "0");
        }
    }
}

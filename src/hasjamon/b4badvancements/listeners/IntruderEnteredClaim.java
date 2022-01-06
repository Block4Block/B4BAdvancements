package hasjamon.b4badvancements.listeners;

import hasjamon.b4badvancements.B4BAdvancements;
import hasjamon.b4badvancements.advancements.IntruderAlertAdvancement;
import hasjamon.block4block.events.IntruderEnteredClaimEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class IntruderEnteredClaim implements Listener {
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onIntruderEnteredClaim(IntruderEnteredClaimEvent e) {
        B4BAdvancements.awardCriteria(e.claimOwner, IntruderAlertAdvancement.ID, "0");
    }
}

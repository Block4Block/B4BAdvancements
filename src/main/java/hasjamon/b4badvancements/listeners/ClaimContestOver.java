package hasjamon.b4badvancements.listeners;

import hasjamon.b4badvancements.B4BAdvancements;
import hasjamon.b4badvancements.advancements.WinClaimContestAdvancement;
import hasjamon.block4block.events.ClaimContestOverEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class ClaimContestOver implements Listener {
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onClaimContestOver(ClaimContestOverEvent e) {
        B4BAdvancements.awardCriteria(e.winner, WinClaimContestAdvancement.ID, "0");
    }
}

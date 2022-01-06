package hasjamon.b4badvancements.listeners;

import hasjamon.b4badvancements.B4BAdvancements;
import hasjamon.b4badvancements.advancements.LoseClaimWhileOfflineAdvancement;
import hasjamon.block4block.events.ClaimLostWhileOfflineEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class ClaimLostWhileOffline implements Listener {
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onClaimLostWhileOffline(ClaimLostWhileOfflineEvent e){
        B4BAdvancements.awardCriteria(e.player, LoseClaimWhileOfflineAdvancement.ID, "0");
    }
}
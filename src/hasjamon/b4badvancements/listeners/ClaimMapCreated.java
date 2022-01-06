package hasjamon.b4badvancements.listeners;

import hasjamon.b4badvancements.B4BAdvancements;
import hasjamon.b4badvancements.advancements.CreateClaimMapAdvancement;
import hasjamon.block4block.events.ClaimMapCreatedEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class ClaimMapCreated implements Listener {
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onClaimMapCreated(ClaimMapCreatedEvent e){
        B4BAdvancements.awardCriteria(e.player, CreateClaimMapAdvancement.ID, "0");
    }
}
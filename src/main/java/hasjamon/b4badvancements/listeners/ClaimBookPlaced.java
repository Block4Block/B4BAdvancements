package hasjamon.b4badvancements.listeners;

import hasjamon.b4badvancements.B4BAdvancements;
import hasjamon.b4badvancements.advancements.ClaimChunkAdvancement;
import hasjamon.block4block.events.ClaimBookPlacedEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class ClaimBookPlaced implements Listener {
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onClaimBookPlaced(ClaimBookPlacedEvent e) {
        if(e.isMember){
            B4BAdvancements.awardCriteria(e.player, ClaimChunkAdvancement.ID, "0");
        }
    }
}

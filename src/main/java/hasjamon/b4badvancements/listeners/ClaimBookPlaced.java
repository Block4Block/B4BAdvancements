package hasjamon.b4badvancements.listeners;

import hasjamon.b4badvancements.B4BAdvancements;
import hasjamon.b4badvancements.advancements.ClaimChunkAdvancement;
import hasjamon.b4badvancements.advancements.ProtectClaimFromAllSidesAdvancement;
import hasjamon.block4block.events.ClaimBookPlacedEvent;
import hasjamon.block4block.utils.utils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class ClaimBookPlaced implements Listener {
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onClaimBookPlaced(ClaimBookPlacedEvent event) {
        if(event.isMember){
            int numProtectiveBlockFaces = utils.protectiveBlockFaces.size();
            boolean isProtectedFromAllSides = utils.countProtectedSides(event.lectern) == numProtectiveBlockFaces;
            if (isProtectedFromAllSides)
                B4BAdvancements.awardCriteria(event.player, ProtectClaimFromAllSidesAdvancement.ID, "0");
            B4BAdvancements.awardCriteria(event.player, ClaimChunkAdvancement.ID, "0");
        }
    }
}

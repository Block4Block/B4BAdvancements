package hasjamon.b4badvancements.listeners;

import hasjamon.b4badvancements.B4BAdvancements;
import hasjamon.b4badvancements.advancements.FailBlockPlaceInClaimAdvancement;
import hasjamon.block4block.events.BlockPlaceInClaimEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class BlockPlaceInClaim implements Listener {
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onBlockPlaceInClaim(BlockPlaceInClaimEvent e) {
        if(!e.success){
            B4BAdvancements.awardCriteria(e.player, FailBlockPlaceInClaimAdvancement.ID, "0");
        }
    }
}

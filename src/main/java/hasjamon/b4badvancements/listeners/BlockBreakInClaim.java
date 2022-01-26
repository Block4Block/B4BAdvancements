package hasjamon.b4badvancements.listeners;

import hasjamon.b4badvancements.B4BAdvancements;
import hasjamon.b4badvancements.advancements.BlockBreakInClaimAdvancement;
import hasjamon.block4block.events.BlockBreakInClaimEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class BlockBreakInClaim implements Listener {
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onBlockBreakInClaim(BlockBreakInClaimEvent e) {
        if(e.success){
            B4BAdvancements.awardCriteria(e.player, BlockBreakInClaimAdvancement.ID, "0");
        }
    }
}

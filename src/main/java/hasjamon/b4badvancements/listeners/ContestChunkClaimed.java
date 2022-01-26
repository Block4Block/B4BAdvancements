package hasjamon.b4badvancements.listeners;

import hasjamon.b4badvancements.B4BAdvancements;
import hasjamon.b4badvancements.advancements.ClaimContestChunkAdvancement;
import hasjamon.block4block.events.ContestChunkClaimedEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class ContestChunkClaimed implements Listener {
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onContestChunkClaimed(ContestChunkClaimedEvent e) {
        Player player = Bukkit.getServer().getPlayerExact(e.claimant);

        if(player != null){
            B4BAdvancements.awardCriteria(player, ClaimContestChunkAdvancement.ID, "0");
        }
    }
}

package hasjamon.b4badvancements.listeners;

import hasjamon.b4badvancements.B4BAdvancements;
import hasjamon.b4badvancements.advancements.FailBlockPlaceInClaimAdvancement;
import hasjamon.b4badvancements.advancements.ProtectClaimFromAllSidesAdvancement;
import hasjamon.b4badvancements.advancements.ProtectClaimWithGravityBlockAdvancement;
import hasjamon.block4block.events.BlockPlaceInClaimEvent;
import hasjamon.block4block.utils.utils;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class BlockPlaceInClaim implements Listener {
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onBlockPlaceInClaim(BlockPlaceInClaimEvent event) {
        if (event.success) {
            Block blockBelow = event.block.getRelative(BlockFace.DOWN);
            int numProtectiveBlockFaces = utils.protectiveBlockFaces.size();
            boolean isProtectedFromAllSides = utils.getClaimBlocksProtectedBy(event.block).stream()
                    .map(utils::countProtectedSides)
                    .anyMatch(protectedSides -> protectedSides == numProtectiveBlockFaces);
            if (isProtectedFromAllSides)
                B4BAdvancements.awardCriteria(event.player, ProtectClaimFromAllSidesAdvancement.ID, "0");
            if (event.block.getType().hasGravity() && !utils.getClaimBlocksProtectedBy(blockBelow).isEmpty())
                B4BAdvancements.awardCriteria(event.player, ProtectClaimWithGravityBlockAdvancement.ID, "0");
        } else {
            B4BAdvancements.awardCriteria(event.player, FailBlockPlaceInClaimAdvancement.ID, "0");
        }
    }
}

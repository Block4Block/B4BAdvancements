package hasjamon.b4badvancements.listeners;

import hasjamon.b4badvancements.B4BAdvancements;
import hasjamon.b4badvancements.advancements.RemoveGrassAdvancement;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFadeEvent;

public class BlockFade implements Listener {
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onBlockFade(BlockFadeEvent e) {
        if(e.getBlock().getType() == Material.GRASS_BLOCK && e.getNewState().getType() == Material.DIRT){
            Block blockAbove = e.getBlock().getRelative(0, 1, 0);
            Player player = BlockPlace.last1000BlocksPlacedOnGrass.get(blockAbove);

            if(player != null){
                B4BAdvancements.awardCriteria(player, RemoveGrassAdvancement.ID, "0");
            }
        }
    }
}
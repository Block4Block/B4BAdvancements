package hasjamon.b4badvancements.listeners;

import hasjamon.b4badvancements.B4BAdvancements;
import hasjamon.b4badvancements.advancements.PlaceSkeletonSpawnerAdvancement;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BlockPlace implements Listener {
    public static final Map<Block, Player> last1000BlocksPlacedOnGrass = new HashMap<>();
    private static final LinkedList<Block> last1000BlocksOnGrass = new LinkedList<>();

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onBlockPlace(BlockPlaceEvent e) {
        Block b = e.getBlockPlaced();
        Player p = e.getPlayer();

        if(b.getRelative(0, -1, 0).getType() == Material.GRASS_BLOCK) {

            last1000BlocksPlacedOnGrass.put(b, p);
            last1000BlocksOnGrass.push(b);

            if (last1000BlocksOnGrass.size() > 1000) {
                Block blockRemoved = last1000BlocksOnGrass.removeFirst();
                last1000BlocksPlacedOnGrass.remove(blockRemoved);
            }
        }

        if(b.getType() == Material.SPAWNER){
            if(((CreatureSpawner) b.getState()).getSpawnedType() == EntityType.SKELETON){
                B4BAdvancements.awardCriteria(p, PlaceSkeletonSpawnerAdvancement.ID, "0");
            }
        }
    }
}
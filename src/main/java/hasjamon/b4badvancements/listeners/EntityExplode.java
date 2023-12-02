package hasjamon.b4badvancements.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class EntityExplode implements Listener {
    public static Map<Player, Long> lastNearbyCreeperExplosion = new HashMap<>();

    @EventHandler(priority = EventPriority.MONITOR)
    public void onEntityExplode(EntityExplodeEvent event){
        switch (event.getEntityType()) {
            case CREEPER -> {
                Location location = event.getLocation();
                Optional<World> worldOpt = Optional.ofNullable(location.getWorld());
                List<Entity> nearbyPlayers = worldOpt.map(world ->
                        world.getNearbyEntities(location, 16, 16, 16).stream()
                                .filter(entity -> entity.getType() == EntityType.PLAYER))
                        .orElse(Stream.empty()).toList();
                nearbyPlayers.forEach(player ->
                    lastNearbyCreeperExplosion.put((Player) player, System.nanoTime()));
            }
        }
    }
}
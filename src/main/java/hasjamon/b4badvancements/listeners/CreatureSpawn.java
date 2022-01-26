package hasjamon.b4badvancements.listeners;

import hasjamon.b4badvancements.B4BAdvancements;
import hasjamon.b4badvancements.advancements.BuildIronGolemAdvancement;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class CreatureSpawn implements Listener {
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onCreatureSpawn(CreatureSpawnEvent e){
        if(e.getSpawnReason() == CreatureSpawnEvent.SpawnReason.BUILD_IRONGOLEM) {
            for(Entity entity : e.getEntity().getNearbyEntities(10, 10, 10)){
                if(entity instanceof Player player){
                    B4BAdvancements.awardCriteria(player, BuildIronGolemAdvancement.ID, "0");
                }
            }
        }
    }
}

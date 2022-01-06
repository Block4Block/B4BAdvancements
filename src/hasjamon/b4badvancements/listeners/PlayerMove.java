package hasjamon.b4badvancements.listeners;

import hasjamon.b4badvancements.B4BAdvancements;
import hasjamon.b4badvancements.advancements.StandCenterEndAdvancement;
import hasjamon.b4badvancements.advancements.StandCenterNetherAdvancement;
import hasjamon.b4badvancements.advancements.StandCenterOverworldAdvancement;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener {
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerMove(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        Location loc = player.getLocation();

        if(Math.abs(loc.getX()) <= 25 && Math.abs(loc.getZ()) <= 25 && loc.getWorld() != null){
            switch(loc.getWorld().getEnvironment()){
                case NORMAL -> B4BAdvancements.awardCriteria(player, StandCenterOverworldAdvancement.ID, "0");
                case NETHER -> B4BAdvancements.awardCriteria(player, StandCenterNetherAdvancement.ID, "0");
                case THE_END -> B4BAdvancements.awardCriteria(player, StandCenterEndAdvancement.ID, "0");
            }
        }
    }
}
package hasjamon.b4badvancements.listeners;

import hasjamon.b4badvancements.B4BAdvancements;
import hasjamon.b4badvancements.advancements.DisguiseAdvancement;
import hasjamon.block4block.events.PlayerDisguisedEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class PlayerDisguised implements Listener {
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerDisguised(PlayerDisguisedEvent e) {
        if(!e.disguiser.getUniqueId().equals(e.disguisee.getUniqueId())) {
            B4BAdvancements.awardCriteria(e.disguiser, DisguiseAdvancement.ID, "0");
        }
    }
}

package hasjamon.b4badvancements.listeners;

import hasjamon.b4badvancements.B4BAdvancements;
import hasjamon.b4badvancements.advancements.CreateMasterBookAdvancement;
import hasjamon.block4block.events.MasterBookCreatedEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class MasterBookCreated implements Listener {
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onMasterBookCreated(MasterBookCreatedEvent e){
        B4BAdvancements.awardCriteria(e.player, CreateMasterBookAdvancement.ID, "0");
    }
}
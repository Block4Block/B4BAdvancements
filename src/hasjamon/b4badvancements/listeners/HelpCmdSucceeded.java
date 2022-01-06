package hasjamon.b4badvancements.listeners;

import hasjamon.b4badvancements.B4BAdvancements;
import hasjamon.b4badvancements.advancements.HelpCmdAdvancement;
import hasjamon.block4block.events.HelpCmdSucceededEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class HelpCmdSucceeded implements Listener {
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onHelpCmdSucceeded(HelpCmdSucceededEvent e) {
        B4BAdvancements.awardCriteria(e.player, HelpCmdAdvancement.ID, "0");
    }
}

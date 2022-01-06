package hasjamon.b4badvancements.listeners;

import hasjamon.b4badvancements.B4BAdvancements;
import hasjamon.b4badvancements.advancements.WelcomeMessageAdvancement;
import hasjamon.block4block.events.WelcomeMsgSentEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class WelcomeMsgSent implements Listener {
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onWelcomeMsgSent(WelcomeMsgSentEvent e) {
        B4BAdvancements.awardCriteria(e.player, WelcomeMessageAdvancement.ID, "0");
    }
}

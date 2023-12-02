package hasjamon.b4badvancements.listeners;

import hasjamon.b4badvancements.B4BAdvancements;
import hasjamon.b4badvancements.advancements.B4BreakBlockFailAdvancement;
import hasjamon.b4badvancements.advancements.B4BreakBlockFailButFreeInClaimAdvancement;
import hasjamon.b4badvancements.advancements.B4BreakDirtAdvancement;
import hasjamon.b4badvancements.advancements.B4BreakStoneAdvancement;
import hasjamon.block4block.events.B4BlockBreakEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class B4BlockBreak implements Listener {
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onB4BlockBreakFailed(B4BlockBreakEvent e) {
        if(e.success){
            switch(e.block.getType()){
                case STONE -> B4BAdvancements.awardCriteria(e.player, B4BreakStoneAdvancement.ID, "0");
                case DIRT -> B4BAdvancements.awardCriteria(e.player, B4BreakDirtAdvancement.ID, "0");
            }
        } else {
            if (e.isFreeToBreakInClaim)
                B4BAdvancements.awardCriteria(e.player, B4BreakBlockFailButFreeInClaimAdvancement.ID, "0");
            B4BAdvancements.awardCriteria(e.player, B4BreakBlockFailAdvancement.ID, "0");
        }
    }
}

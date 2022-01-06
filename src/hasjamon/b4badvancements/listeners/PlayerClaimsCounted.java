package hasjamon.b4badvancements.listeners;

import hasjamon.b4badvancements.B4BAdvancements;
import hasjamon.b4badvancements.advancements.*;
import hasjamon.block4block.events.PlayerClaimsCountedEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class PlayerClaimsCounted implements Listener {
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerClaimsCounted(PlayerClaimsCountedEvent e) {
        if(e.numClaims >= 5){
            B4BAdvancements.awardCriteria(e.player, Claim5ChunksAdvancement.ID, "0");
            if(e.numClaims >= 10){
                B4BAdvancements.awardCriteria(e.player, Claim10ChunksAdvancement.ID, "0");
                if(e.numClaims >= 25){
                    B4BAdvancements.awardCriteria(e.player, Claim25ChunksAdvancement.ID, "0");
                    if(e.numClaims >= 50){
                        B4BAdvancements.awardCriteria(e.player, Claim50ChunksAdvancement.ID, "0");
                        if(e.numClaims >= 100){
                            B4BAdvancements.awardCriteria(e.player, Claim100ChunksAdvancement.ID, "0");
                            if(e.numClaims >= 250){
                                B4BAdvancements.awardCriteria(e.player, Claim250ChunksAdvancement.ID, "0");
                                if(e.numClaims >= 500){
                                    B4BAdvancements.awardCriteria(e.player, Claim500ChunksAdvancement.ID, "0");
                                    if(e.numClaims >= 1000){
                                        B4BAdvancements.awardCriteria(e.player, Claim1000ChunksAdvancement.ID, "0");
                                        if(e.numClaims >= 10000){
                                            B4BAdvancements.awardCriteria(e.player, Claim10000ChunksAdvancement.ID, "0");
                                            if(e.numClaims >= 100000){
                                                B4BAdvancements.awardCriteria(e.player, Claim100000ChunksAdvancement.ID, "0");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

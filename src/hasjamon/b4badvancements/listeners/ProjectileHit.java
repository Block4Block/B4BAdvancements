package hasjamon.b4badvancements.listeners;

import hasjamon.b4badvancements.B4BAdvancements;
import hasjamon.b4badvancements.advancements.HitDripstoneWithTridentAdvancement;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.projectiles.ProjectileSource;

public class ProjectileHit implements Listener {
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onProjectileHit(ProjectileHitEvent e) {
        Block hitBlock = e.getHitBlock();

        if(hitBlock != null) {
            if (e.getEntityType() == EntityType.TRIDENT && hitBlock.getType() == Material.POINTED_DRIPSTONE) {
                ProjectileSource shooter = e.getEntity().getShooter();

                if(shooter instanceof Player){
                    B4BAdvancements.awardCriteria((Player) shooter, HitDripstoneWithTridentAdvancement.ID, "0");
                }
            }
        }
    }
}
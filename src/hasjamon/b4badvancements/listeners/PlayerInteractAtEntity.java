package hasjamon.b4badvancements.listeners;

import hasjamon.b4badvancements.B4BAdvancements;
import hasjamon.b4badvancements.advancements.NameChickenAdvancement;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteractAtEntity implements Listener {
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerInteractAtEntity(PlayerInteractAtEntityEvent e) {
        if(e.getRightClicked().getType() == EntityType.CHICKEN) {
            Player player = e.getPlayer();
            ItemStack item = player.getInventory().getItemInMainHand();

            if (item.getType() == Material.NAME_TAG) {
                B4BAdvancements.awardCriteria(player, NameChickenAdvancement.ID, "0");
            }
        }
    }
}

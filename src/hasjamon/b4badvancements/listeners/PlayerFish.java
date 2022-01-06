package hasjamon.b4badvancements.listeners;

import hasjamon.b4badvancements.B4BAdvancements;
import hasjamon.b4badvancements.advancements.FishGetRareStuffAdvancement;
import hasjamon.b4badvancements.advancements.FishGetSpawnEggAdvancement;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;

public class PlayerFish implements Listener {
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerFish(PlayerFishEvent e){
        if(e.getState() == PlayerFishEvent.State.CAUGHT_FISH){
            if(e.getCaught().getType() == EntityType.DROPPED_ITEM){
                Player player = e.getPlayer();
                Material itemType = ((Item) e.getCaught()).getItemStack().getType();

                switch(itemType){
                    case TROPICAL_FISH_SPAWN_EGG -> {
                        B4BAdvancements.awardCriteria(player, FishGetSpawnEggAdvancement.ID, "0");
                    }
                    case NAME_TAG, SADDLE, NAUTILUS_SHELL -> {
                        B4BAdvancements.awardCriteria(player, FishGetRareStuffAdvancement.ID, "0");
                    }
                }
            }
        }
    }
}
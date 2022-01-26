package hasjamon.b4badvancements.listeners;

import com.google.common.collect.Lists;
import hasjamon.b4badvancements.B4BAdvancements;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;
import java.util.List;

public class EntityDeath implements Listener {
    public static final String NEW_DROP_PREFIX = "*NEW*";

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onEntityDeath(EntityDeathEvent e) {
        List<ItemStack> drops = e.getDrops();
        Entity deadEntity = e.getEntity();

        if(!(deadEntity instanceof InventoryHolder)){
            List<ItemStack> valuables = drops.stream().filter(
                    drop -> PickupItem.valuableDrops.contains(drop.getType())).toList();

            for(var valuable : valuables){
                ItemMeta meta = valuable.getItemMeta();

                if(meta != null){
                    if(valuable.getType() == Material.DIAMOND_BLOCK) {
                        meta.setDisplayName("Curtis Mayfield's Diamond Block");
                        meta.setLore(Lists.newArrayList(NEW_DROP_PREFIX + "\"Dude, why you do that to my car?\" - Curtis Mayfield"));
                    }else{
                        if(B4BAdvancements.canUseReflection){
                            meta.setDisplayName("Lucky " + B4BAdvancements.getItemName(valuable));
                        }
                        meta.setLore(Lists.newArrayList(NEW_DROP_PREFIX + "Extremely lucky random drop"));
                    }

                    valuable.setItemMeta(meta);
                }
            }
        }

        if(B4BAdvancements.canUseReflection) {
            List<ItemStack> heads = drops.stream().filter(this::isHeadOrSkull).toList();

            if (heads.size() > 0) {
                if (deadEntity instanceof InventoryHolder) {
                    Inventory inv = ((InventoryHolder) deadEntity).getInventory();
                    List<ItemStack> items = Arrays.stream(inv.getStorageContents()).toList();

                    heads = heads.stream().filter(h -> !items.contains(h)).toList();
                }

                for (var head : heads) {
                    ItemMeta meta = head.getItemMeta();

                    if(meta != null) {
                        if (head.getType() == Material.PLAYER_HEAD) {
                            SkullMeta skullMeta = (SkullMeta) meta;
                            OfflinePlayer headOwner = skullMeta.getOwningPlayer();

                            // If it's a mob head (i.e., not from a player)
                            if(headOwner == null || headOwner.getFirstPlayed() <= 0){
                                String headName = B4BAdvancements.getItemName(head);
                                meta.setLore(Lists.newArrayList(
                                        NEW_DROP_PREFIX + headName.substring(0, headName.length() - 7)));
                            }
                        }else{
                            meta.setLore(Lists.newArrayList(NEW_DROP_PREFIX));
                        }

                        head.setItemMeta(meta);
                    }
                }
            }
        }
    }

    private boolean isHeadOrSkull(ItemStack itemStack) {
        switch(itemStack.getType()){
            case PLAYER_HEAD, SKELETON_SKULL, WITHER_SKELETON_SKULL, CREEPER_HEAD, DRAGON_HEAD, ZOMBIE_HEAD -> {
                return true;
            }
            default -> {
                return false;
            }
        }
    }
}

package hasjamon.b4badvancements.listeners;

import com.google.common.collect.Sets;
import hasjamon.b4badvancements.B4BAdvancements;
import hasjamon.b4badvancements.advancements.JumpOnFarmlandAdvancement;
import hasjamon.b4badvancements.advancements.SpawnZombieHorseAdvancement;
import hasjamon.b4badvancements.advancements.SpreadNyliumAdvancement;
import hasjamon.b4badvancements.advancements.UseAllSpawnEggsAdvancement;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashSet;

public class PlayerInteract implements Listener {
    public static final HashSet<Material> spawnEggs = Sets.newHashSet(
            Material.SPIDER_SPAWN_EGG, Material.BAT_SPAWN_EGG, Material.BEE_SPAWN_EGG, Material.CAT_SPAWN_EGG,
            Material.CAVE_SPIDER_SPAWN_EGG, Material.COD_SPAWN_EGG, Material.COW_SPAWN_EGG, Material.CREEPER_SPAWN_EGG,
            Material.DOLPHIN_SPAWN_EGG, Material.DONKEY_SPAWN_EGG, Material.DROWNED_SPAWN_EGG,
            Material.ENDERMITE_SPAWN_EGG, Material.FOX_SPAWN_EGG, Material.GOAT_SPAWN_EGG,
            Material.GLOW_SQUID_SPAWN_EGG, Material.HORSE_SPAWN_EGG, Material.HUSK_SPAWN_EGG,
            Material.LLAMA_SPAWN_EGG, Material.MULE_SPAWN_EGG, Material.OCELOT_SPAWN_EGG, Material.PANDA_SPAWN_EGG,
            Material.PARROT_SPAWN_EGG, Material.PHANTOM_SPAWN_EGG, Material.PIG_SPAWN_EGG, Material.PILLAGER_SPAWN_EGG,
            Material.POLAR_BEAR_SPAWN_EGG, Material.PUFFERFISH_SPAWN_EGG, Material.RABBIT_SPAWN_EGG,
            Material.SALMON_SPAWN_EGG, Material.SHEEP_SPAWN_EGG, Material.SILVERFISH_SPAWN_EGG,
            Material.SKELETON_SPAWN_EGG, Material.SQUID_SPAWN_EGG, Material.TRADER_LLAMA_SPAWN_EGG,
            Material.TURTLE_SPAWN_EGG, Material.TROPICAL_FISH_SPAWN_EGG, Material.WOLF_SPAWN_EGG,
            Material.ZOMBIE_SPAWN_EGG, Material.STRIDER_SPAWN_EGG, Material.SLIME_SPAWN_EGG,
            Material.WANDERING_TRADER_SPAWN_EGG, Material.AXOLOTL_SPAWN_EGG, Material.ZOMBIFIED_PIGLIN_SPAWN_EGG,
            Material.VEX_SPAWN_EGG, Material.WITCH_SPAWN_EGG, Material.VINDICATOR_SPAWN_EGG, Material.STRAY_SPAWN_EGG,
            Material.GUARDIAN_SPAWN_EGG, Material.ENDERMAN_SPAWN_EGG, Material.PIGLIN_SPAWN_EGG,
            Material.PIGLIN_BRUTE_SPAWN_EGG, Material.ZOGLIN_SPAWN_EGG, Material.HOGLIN_SPAWN_EGG,
            Material.MAGMA_CUBE_SPAWN_EGG, Material.BLAZE_SPAWN_EGG, Material.RAVAGER_SPAWN_EGG,
            Material.WITHER_SKELETON_SPAWN_EGG, Material.SHULKER_SPAWN_EGG, Material.EVOKER_SPAWN_EGG,
            Material.SKELETON_HORSE_SPAWN_EGG, Material.VILLAGER_SPAWN_EGG, Material.ZOMBIE_VILLAGER_SPAWN_EGG,
            Material.MOOSHROOM_SPAWN_EGG, Material.ELDER_GUARDIAN_SPAWN_EGG, Material.GHAST_SPAWN_EGG,
            Material.CHICKEN_SPAWN_EGG, Material.FROG_SPAWN_EGG, Material.TADPOLE_SPAWN_EGG, Material.ALLAY_SPAWN_EGG,
            Material.WARDEN_SPAWN_EGG, Material.SNIFFER_SPAWN_EGG, Material.CAMEL_SPAWN_EGG
    );
    private final B4BAdvancements plugin;

    public PlayerInteract(B4BAdvancements plugin){
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerInteract(PlayerInteractEvent e) {
        Block block = e.getClickedBlock();
        Player player = e.getPlayer();

        if(block != null){
            if (e.getAction() == Action.PHYSICAL){
                if(block.getType() == Material.FARMLAND){
                    B4BAdvancements.awardCriteria(player, JumpOnFarmlandAdvancement.ID, "0");
                }
            }else if(e.getAction() == Action.RIGHT_CLICK_BLOCK){
                ItemStack item = e.getItem();

                if(item != null){
                    Material itemType = item.getType();

                    if(spawnEggs.contains(itemType)){
                        B4BAdvancements.awardCriteria(player, UseAllSpawnEggsAdvancement.ID, itemType.toString());
                    }

                    switch(itemType){
                        case ZOMBIE_HORSE_SPAWN_EGG -> {
                            B4BAdvancements.awardCriteria(player, SpawnZombieHorseAdvancement.ID, "0");
                        }
                        case BONE_MEAL -> {
                            if(block.getType() == Material.NETHERRACK){
                                Bukkit.getScheduler().runTaskLater(plugin, () -> {
                                    Material blockType = block.getType();

                                    if(blockType == Material.WARPED_NYLIUM || blockType == Material.CRIMSON_NYLIUM){
                                        B4BAdvancements.awardCriteria(player, SpreadNyliumAdvancement.ID, "0");
                                    }
                                }, 1);
                            }
                        }
                    }
                }
            }
        }
    }
}

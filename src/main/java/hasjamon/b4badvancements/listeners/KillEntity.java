package hasjamon.b4badvancements.listeners;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.HashMap;
import java.util.Map;

public class KillEntity implements Listener {
    public static Map<Player, Long> lastSkeletonKill = new HashMap<>();
    public static Map<Player, Long> lastWitherSkeletonKill = new HashMap<>();
    public static Map<Player, Long> lastPigKill = new HashMap<>();
    public static Map<Player, Long> lastEndermanKill = new HashMap<>();
    public static Map<Player, Long> lastEndMobKill = new HashMap<>();
    public static Map<Player, Long> lastMooshroomKill = new HashMap<>();
    public static Map<Player, Long> lastPolarBearKill = new HashMap<>();
    public static Map<Player, Long> lastRaiderKill = new HashMap<>();
    public static Map<Player, Long> lastZombieKill = new HashMap<>();
    public static Map<Player, Long> lastWitchKill = new HashMap<>();
    public static Map<Player, Long> lastCreeperKill = new HashMap<>();

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onEntityDeath(EntityDeathEvent e) {
        LivingEntity entity = e.getEntity();
        Player killer = entity.getKiller();

        if(killer != null) {
            switch(entity.getType()){
                case SKELETON -> {
                    lastSkeletonKill.put(killer, System.nanoTime());
                }
                case WITHER_SKELETON -> {
                    lastWitherSkeletonKill.put(killer, System.nanoTime());
                }
                case PIG -> {
                    lastPigKill.put(killer, System.nanoTime());
                }
                case ZOMBIE -> {
                    lastZombieKill.put(killer, System.nanoTime());
                }
                case ENDERMAN -> {
                    lastEndermanKill.put(killer, System.nanoTime());
                    lastEndMobKill.put(killer, System.nanoTime());
                }
                case ENDER_DRAGON, ENDERMITE -> {
                    lastEndMobKill.put(killer, System.nanoTime());
                }
                case MUSHROOM_COW -> {
                    lastMooshroomKill.put(killer, System.nanoTime());
                }
                case POLAR_BEAR -> {
                    lastPolarBearKill.put(killer, System.nanoTime());
                }
                case EVOKER, VEX, VINDICATOR, RAVAGER, PILLAGER -> {
                    lastRaiderKill.put(killer, System.nanoTime());
                }
                case WITCH -> {
                    lastWitchKill.put(killer, System.nanoTime());
                }
                case CREEPER -> {
                    lastCreeperKill.put(killer, System.nanoTime());
                }
            }
        }
    }
}
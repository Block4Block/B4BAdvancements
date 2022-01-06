package hasjamon.b4badvancements.advancements;

import hasjamon.b4badvancements.B4BAdvancements;
import hasjamon.b4badvancements.listeners.PickupItem;
import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class PickupAllMobHeadsAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_pickupallmobheads";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), CollectAllMobHeadsAdvancement.ID));
        advancement.setDisplay(x -> {
            if(B4BAdvancements.canUseReflection) {
                x.setTitle("Mob Master");
            }else{
                x.setTitle("[DISABLED] Mob Master");
            }
            x.setDescription("Obtain all mob heads by yourself; trade, theft, etc. don't count.");
            x.setIcon(Material.DRAGON_HEAD);
        });

        for(String mobHead : PickupItem.mobHeads) {
            advancement.addCriteria(mobHead, TriggerType.IMPOSSIBLE, trigger -> {});
        }

        advancement.addCriteria(Material.SKELETON_SKULL.toString(), TriggerType.IMPOSSIBLE, trigger -> {});
        advancement.addCriteria(Material.WITHER_SKELETON_SKULL.toString(), TriggerType.IMPOSSIBLE, trigger -> {});
        advancement.addCriteria(Material.CREEPER_HEAD.toString(), TriggerType.IMPOSSIBLE, trigger -> {});
        advancement.addCriteria(Material.DRAGON_HEAD.toString(), TriggerType.IMPOSSIBLE, trigger -> {});
        advancement.addCriteria(Material.ZOMBIE_HEAD.toString(), TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
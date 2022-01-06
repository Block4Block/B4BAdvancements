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

public class CollectAllMobHeadsAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_collectallmobheads";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), CollectMobHeadAdvancement.ID));
        advancement.setDisplay(x -> {
            if(B4BAdvancements.canUseReflection) {
                x.setTitle("Mob Boss");
            }else{
                x.setTitle("[DISABLED] Mob Boss");
            }
            x.setDescription("Collect all mob heads and skulls.");
            x.setIcon(Material.WITHER_SKELETON_SKULL);
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
package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class CollectMobHeadAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_collectmobhead";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), KillSkeletonGetStoneAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Mobster");
            x.setDescription("Kill a mob and claim its head.");
            x.setIcon(Material.SKELETON_SKULL);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
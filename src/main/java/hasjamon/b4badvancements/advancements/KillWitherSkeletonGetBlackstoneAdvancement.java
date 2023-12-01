package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class KillWitherSkeletonGetBlackstoneAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_killwitherskeletongetblackstone";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), KillSkeletonGetStoneAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Wither Stone");
            x.setDescription("Kill a Wither Skeleton and loot some Blackstone.");
            x.setIcon(Material.BLACKSTONE);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
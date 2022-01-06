package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class KillEndMobGetEndItemAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_killendmobgetenditem";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), KillSkeletonGetStoneAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("End Game");
            x.setDescription("Kill an End mob and loot some end stone or end rods.");
            x.setIcon(Material.END_STONE);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
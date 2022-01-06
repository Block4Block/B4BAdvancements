package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class B4BreakStoneAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_breakstone";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), KillSkeletonGetStoneAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Stonebreaker");
            x.setDescription("Successfully break a stone block by spending a stone block from your hotbar.");
            x.setIcon(Material.STONE_PICKAXE);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}

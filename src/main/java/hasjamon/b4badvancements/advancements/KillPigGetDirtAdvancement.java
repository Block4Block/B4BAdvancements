package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class KillPigGetDirtAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_killpiggetdirt";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), B4BreakBlockFailAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Dirty Pigs");
            x.setDescription("Obtain dirt from a Pig.");
            x.setIcon(Material.DIRT);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
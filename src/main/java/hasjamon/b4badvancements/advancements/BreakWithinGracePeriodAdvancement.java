package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class BreakWithinGracePeriodAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_breakwithingraceperiod";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), B4BreakBlockFailAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("A Gracious Period");
            x.setDescription("Break a newly placed block within the grace period to avoid spending a block. (default: 5 sec.)");
            x.setIcon(Material.CLOCK);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}

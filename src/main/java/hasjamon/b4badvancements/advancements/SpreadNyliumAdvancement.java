package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class SpreadNyliumAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_spreadnylium";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), BreakNyliumFreelyAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Spreading Nylium");
            x.setDescription("Apply bone meal to netherrack sitting next to nylium to convert it to nylium.");
            x.setIcon(Material.BONE_MEAL);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}

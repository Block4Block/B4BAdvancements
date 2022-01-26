package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class PickFlowerAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_pickflower";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), BreakLogsFreelyAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Watering Flowers");
            x.setDescription("Pick up a flower. (Use a water bucket to break flowers)");
            x.setIcon(Material.POPPY);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
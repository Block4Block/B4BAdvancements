package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class StandCenterEndAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_standcenterend";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), StandCenterNetherAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Origin of The Big Bang");
            x.setDescription("Travel to the center of the End.");
            x.setIcon(Material.GOLDEN_BOOTS);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
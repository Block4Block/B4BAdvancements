package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class BreakNyliumFreelyAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_breaknyliumfreely";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), BreakBedFreelyAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Breaking Nylium");
            x.setDescription("Yup, both kinds of Nylium are free to break as well.");
            x.setIcon(Material.CRIMSON_NYLIUM);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}

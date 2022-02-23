package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class BreakAndesiteAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_breakandesite";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), BreakBedFreelyAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("And The Side");
            x.setDescription("Breaking andesite is sure to make quite a splash!");
            x.setIcon(Material.ANDESITE);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}

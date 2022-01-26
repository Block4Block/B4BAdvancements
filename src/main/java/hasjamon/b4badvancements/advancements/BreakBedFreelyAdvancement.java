package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class BreakBedFreelyAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_breakbedfreely";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), BreakCraftingTableFreelyAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Favourite Bed");
            x.setDescription("I'm not getting a new one! I've finally gotten used to the mattress. (Also free to break: ores, torches...)");
            x.setIcon(Material.BLUE_BED);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}

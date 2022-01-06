package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class BreakCraftingTableFreelyAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_breakcraftingtablefreely";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), BreakLeavesFreelyAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("iCraftyTable");
            x.setDescription("Crafting on the go. (Crafting Tables are free to break, as are ores, beds, ladders, torches...)");
            x.setIcon(Material.CRAFTING_TABLE);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}

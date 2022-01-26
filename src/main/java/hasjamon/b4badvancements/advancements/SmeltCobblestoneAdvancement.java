package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class SmeltCobblestoneAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_smeltcobblestone";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), B4BreakStoneAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Stone Cobbler");
            x.setDescription("Smelt cobblestone back into stone using a furnace.");
            x.setIcon(Material.FURNACE);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
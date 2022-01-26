package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class LotsOfCobblestoneAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_lotsofcobblestone";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), B4BreakStoneAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Speedy Stonebreaker");
            x.setDescription("Equip a diamond or netherite pickaxe and have 5 full stacks of cobblestone.");
            x.setIcon(Material.DIAMOND_PICKAXE);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}

package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.display.BackgroundType;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

public class PickupSugarCaneAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_pickupsugarcane";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setDisplay(x -> {
            x.setTitle("Aspiring Land Owner");
            x.setDescription("Sugar Cane is the first step towards claiming land!");
            x.setBackground(BackgroundType.STONE);
            x.setIcon(Material.ENCHANTED_BOOK);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
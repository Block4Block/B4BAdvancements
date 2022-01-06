package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class StandCenterNetherAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_standcenternether";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), StandCenterOverworldAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Ground Zero");
            x.setDescription("Travel to the center of the Nether.");
            x.setIcon(Material.NETHERITE_BOOTS);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
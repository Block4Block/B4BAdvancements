package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class KillMooshroomGetStuffAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_killmooshroomgetstuff";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), KillPolarBearGetIceAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("35 to 42 Days");
            x.setDescription("Obtain mushrooms from a Mooshroom.");
            x.setIcon(Material.RED_MUSHROOM);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
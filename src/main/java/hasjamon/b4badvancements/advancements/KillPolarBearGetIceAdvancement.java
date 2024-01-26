package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class KillPolarBearGetIceAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_killpolarbeargetice";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), PickFlowerAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Ice Cold Murder");
            x.setDescription("Obtain ice from a Polar Bear.");
            x.setIcon(Material.ICE);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
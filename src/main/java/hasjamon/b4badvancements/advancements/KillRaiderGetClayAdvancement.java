package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class KillRaiderGetClayAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_killraidergetclay";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), PickupFallingBlockAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Clayment");
            x.setDescription("Obtain clay from a Pillager, Ravager, Vindicator, Evoker, or Vex.");
            x.setIcon(Material.CLAY);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
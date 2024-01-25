package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class PickupPumpkinAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_pickuppumpkin";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), PickupMelonSliceAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Pumpkin Pusher");
            x.setDescription("Pick up a Pumpkin after indirectly breaking it.");
            x.setIcon(Material.PUMPKIN);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class PickupMelonSliceAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_pickupmelonslice";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), PickFlowerAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Whack a Melon");
            x.setDescription("A piston pushed a melon and you grabbed a few slices.");
            x.setIcon(Material.MELON);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class PickupSpawnEggAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_pickupspawnegg";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), PickupFallingBlockAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Egguse me!?");
            x.setDescription("Pick up any spawn egg laid by a chicken.");
            x.setIcon(Material.PIG_SPAWN_EGG);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
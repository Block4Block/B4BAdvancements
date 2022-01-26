package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class PickupRareSpawnEggAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_pickuprarespawnegg";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), PickupSpawnEggAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Eggcellent!");
            x.setDescription("Pick up a rare spawn egg.");
            x.setIcon(Material.WANDERING_TRADER_SPAWN_EGG);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
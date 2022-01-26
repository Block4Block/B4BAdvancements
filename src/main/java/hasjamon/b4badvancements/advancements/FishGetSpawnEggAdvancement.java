package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class FishGetSpawnEggAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_fishgetspawnegg";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), PickFlowerAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Tropical Fishing");
            x.setDescription("Catch a Tropical Fish Spawn Egg while Fishing.");
            x.setIcon(Material.TROPICAL_FISH_SPAWN_EGG);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
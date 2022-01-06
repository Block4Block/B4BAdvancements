package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class PlaceSkeletonSpawnerAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_placeskeletonspawner";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), PickupSpawnerAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Stone Fabricator");
            x.setDescription("Set up a stone generator by placing a skeleton spawner.");
            x.setIcon(Material.SKELETON_SKULL);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
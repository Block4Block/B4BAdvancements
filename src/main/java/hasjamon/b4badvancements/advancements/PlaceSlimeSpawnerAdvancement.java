package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class PlaceSlimeSpawnerAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_placeslimespawner";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), SpreadNyliumAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Cubical Conversion Therapy");
            x.setDescription("Turn a Magma Cube Spawner into a Slime Spawner by placing it in The Overworld.");
            x.setIcon(Material.SLIME_BLOCK);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class PickupSpawnerAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_pickupspawner";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), B4BreakStoneAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Spawner of Mobs");
            x.setDescription("Break a Spawner using a pickaxe and pick it up.");
            x.setIcon(Material.SPAWNER);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
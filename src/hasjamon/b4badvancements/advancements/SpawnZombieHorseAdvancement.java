package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class SpawnZombieHorseAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_spawnzombiehorse";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), PickupSuperRareSpawnEggAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Zemgg");
            x.setDescription("Spawn a Zombie Horse.");
            x.setIcon(Material.PIG_SPAWN_EGG);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
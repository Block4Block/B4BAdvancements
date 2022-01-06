package hasjamon.b4badvancements.advancements;

import hasjamon.b4badvancements.listeners.PlayerInteract;
import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class UseAllSpawnEggsAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_useallspawneggs";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), SpawnZombieHorseAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Egghead Extraordinaire");
            x.setDescription("Use each type of spawn egg at least once.");
            x.setIcon(Material.CHICKEN_SPAWN_EGG);
        });

        for(Material spawnEgg : PlayerInteract.spawnEggs) {
            advancement.addCriteria(spawnEgg.toString(), TriggerType.IMPOSSIBLE, trigger -> {});
        }

        return advancement;
    }
}
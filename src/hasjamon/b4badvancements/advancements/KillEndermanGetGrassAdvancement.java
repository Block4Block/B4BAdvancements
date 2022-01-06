package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class KillEndermanGetGrassAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_killendermangetgrass";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), RemoveGrassAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Helping Hand");
            x.setDescription("Obtain a grass block from an Enderman.");
            x.setIcon(Material.GRASS_BLOCK);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
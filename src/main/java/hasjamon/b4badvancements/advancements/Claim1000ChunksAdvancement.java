package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class Claim1000ChunksAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_claim1000chunks";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), Claim500ChunksAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Duke");
            x.setDescription("Own 1000 claims.");
            x.setIcon(Material.RED_NETHER_BRICK_WALL);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}

package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class Claim10000ChunksAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_claim10000chunks";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), Claim1000ChunksAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("King");
            x.setDescription("Own 10000 claims.");
            x.setIcon(Material.PRISMARINE_WALL);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}

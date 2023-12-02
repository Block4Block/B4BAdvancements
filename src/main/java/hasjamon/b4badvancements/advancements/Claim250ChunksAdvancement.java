package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class Claim250ChunksAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_claim250chunks";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), Claim100ChunksAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Earl");
            x.setDescription("Own 250 claims.");
            x.setIcon(Material.GRANITE_WALL);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}

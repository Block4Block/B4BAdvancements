package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class Claim100000ChunksAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_claim100000chunks";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), Claim10000ChunksAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Emperor");
            x.setDescription("Claim 100000 chunks.");
            x.setIcon(Material.DIAMOND_BLOCK);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}

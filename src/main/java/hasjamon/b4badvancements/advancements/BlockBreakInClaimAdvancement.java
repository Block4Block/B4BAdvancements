package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class BlockBreakInClaimAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_breakinclaim";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), ClaimChunkAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Reclaimed Rights");
            x.setDescription("Some blocks are free to break, if you have a claim. In this case, you do.");
            x.setIcon(Material.RED_BANNER);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}

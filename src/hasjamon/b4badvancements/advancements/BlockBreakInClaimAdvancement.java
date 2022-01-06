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
            x.setDescription("Break something for free inside your claim. (See list of free-to-break blocks in /b4bhelp).");
            x.setIcon(Material.RED_BANNER);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}

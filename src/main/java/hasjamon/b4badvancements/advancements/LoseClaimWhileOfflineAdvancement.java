package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class LoseClaimWhileOfflineAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_loseclaimwhileoffline";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), ClaimChunkAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Claim Down!");
            x.setDescription("Lose a claim or have your name removed from a master book while offline.");
            x.setIcon(Material.SKULL_BANNER_PATTERN);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class ClaimContestChunkAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_claimcontestchunk";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), ClaimChunkAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Claim Contest Contender");
            x.setDescription("Own the current Claim Contest zone. Good luck keeping it!");
            x.setIcon(Material.IRON_HELMET);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}

package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class RemoveClaimAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_removeclaim";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), FailBlockPlaceInClaimAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Annexation");
            x.setDescription("Steal the claim book or break the lectern of another player's claim.");
            x.setIcon(Material.WARPED_FENCE_GATE);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}

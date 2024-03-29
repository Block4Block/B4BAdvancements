package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class PickupValuableRandomDropAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_pickupvaluablerandomdrop";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), KillPhantomGetElytraAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Extraordinary Luck");
            x.setDescription("You found something extraordinary from an unexpected source.");
            x.setIcon(Material.DIAMOND_BLOCK);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
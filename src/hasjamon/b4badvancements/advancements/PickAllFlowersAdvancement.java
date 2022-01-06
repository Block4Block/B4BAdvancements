package hasjamon.b4badvancements.advancements;

import hasjamon.b4badvancements.listeners.PickupItem;
import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class PickAllFlowersAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_pickallflowers";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), PickFlowerAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Mother's Day Bouquet");
            x.setDescription("Pick up one of each flower. (Use a water bucket to break flowers)");
            x.setIcon(Material.ROSE_BUSH);
        });

        for(Material flower : PickupItem.flowers) {
            advancement.addCriteria(flower.toString(), TriggerType.IMPOSSIBLE, trigger -> {});
        }

        return advancement;
    }
}
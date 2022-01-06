package hasjamon.b4badvancements.advancements;

import hasjamon.b4badvancements.listeners.CraftItem;
import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class CraftAllDyesAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_pickcraftalldyes";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), PickAllFlowersAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Mother's Tears");
            x.setDescription("Craft every craftable dye.");
            x.setIcon(Material.BROWN_DYE);
        });

        for(Material dye : CraftItem.craftableDyes) {
            advancement.addCriteria(dye.toString(), TriggerType.IMPOSSIBLE, trigger -> {});
        }

        return advancement;
    }
}
package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class BedCmdAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_bedcmd";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), HelpCmdAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Emergency Bed");
            x.setDescription("Write '/bed' in Chat for a free bed, available once a day");
            x.setIcon(Material.WHITE_BED);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}

package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class BreakLogsFreelyAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_breaklogsfreely";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), B4BreakBlockFailAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Got to Break Tree");
            x.setDescription("Logs are free to break! You better try every block.");
            x.setIcon(Material.OAK_LOG);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}

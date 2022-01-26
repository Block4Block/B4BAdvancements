package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class HelpCmdAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_helpcmd";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), KillPigGetDirtAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Helpful Command");
            x.setDescription("You've found help (hopefully) by using the /b4bhelp command.");
            x.setIcon(Material.GLASS_PANE);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}

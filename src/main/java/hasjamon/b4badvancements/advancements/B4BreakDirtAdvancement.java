package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class B4BreakDirtAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_breakdirt";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), KillPigGetDirtAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Dirtbreaker");
            x.setDescription("Successfully break dirt by spending a dirt block from your hotbar.");
            x.setIcon(Material.IRON_SHOVEL);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}

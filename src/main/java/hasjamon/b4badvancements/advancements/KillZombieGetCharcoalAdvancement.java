package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class KillZombieGetCharcoalAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_killzombiegetcharcoal";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), B4BreakBlockFailAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Wooden Brain");
            x.setDescription("Kill a Zombie and loot some Charcoal.");
            x.setIcon(Material.CHARCOAL);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
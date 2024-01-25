package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class B4BreakBlockFailAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_breakblockfail";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), WelcomeMessageAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("A Block for a Block");
            x.setDescription("Some blocks in the world requires you to spend a block to break them!");
            x.setIcon(Material.OAK_PLANKS);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}

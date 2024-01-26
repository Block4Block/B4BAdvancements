package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class KillPhantomGetElytraAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_killphantomgetelytra";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), KillMooshroomGetStuffAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Phantom Elytra");
            x.setDescription("Obtain a Phantom Elytra from a Phantom.");
            x.setIcon(Material.ELYTRA);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
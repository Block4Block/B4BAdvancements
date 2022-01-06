package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class FishGetRareStuffAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_fishgetrarestuff";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), FishGetSpawnEggAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Exotic Fishing");
            x.setDescription("Catch a rare fishing reward.");
            x.setIcon(Material.NAUTILUS_SHELL);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
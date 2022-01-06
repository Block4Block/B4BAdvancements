package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class NameChickenAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_namechicken";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), PickupSpawnEggAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Chicken Little");
            x.setDescription("Name a chicken to give it an aura that buffs the drops of nearby chickens.");
            x.setIcon(Material.NAME_TAG);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
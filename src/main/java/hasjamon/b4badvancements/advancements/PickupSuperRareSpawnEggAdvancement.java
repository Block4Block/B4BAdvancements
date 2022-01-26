package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class PickupSuperRareSpawnEggAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_pickupsuperrarespawnegg";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), PickupRareSpawnEggAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Eggstraordinarily Eggstatic!");
            x.setDescription("Pick up a super rare spawn egg.");
            x.setIcon(Material.ELDER_GUARDIAN_SPAWN_EGG);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
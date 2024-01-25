package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class JumpOnFarmlandAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_jumponfarmland";
// TODO : Remove JumpOnFarmlandAdvancement and adjust associated code. Triggered too often without proper player interaction and isn't a relevant dirtbreaking method anymore.
    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), RemoveGrassAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Farmland Stomper");
            x.setDescription("Turn farmland into dirt by jumping on it.");
            x.setIcon(Material.FARMLAND);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
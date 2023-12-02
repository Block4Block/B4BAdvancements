package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class CreeperExplodeGetGunpowderAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_creeperexplodegetgunpowder";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), KillCreeperOrWitchGetRocketAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Creepy Remnants");
            x.setDescription("Pick up gunpowder after a creeper explodes.");
            x.setIcon(Material.GUNPOWDER);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
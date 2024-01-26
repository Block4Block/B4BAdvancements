package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class KillCreeperOrWitchGetRocketAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_killcreeperorwitchgetrocket";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), KillZombieGetCharcoalAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Rocketpowered Creeps");
            x.setDescription("Obtain a Rocket from a Creeper or a Witch.");
            x.setIcon(Material.FIREWORK_ROCKET);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class StandCenterOverworldAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_standcenteroverworld";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), KillPigGetDirtAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Central Hub");
            x.setDescription("Travel to the center of the Overworld.");
            x.setIcon(Material.LEATHER_BOOTS);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
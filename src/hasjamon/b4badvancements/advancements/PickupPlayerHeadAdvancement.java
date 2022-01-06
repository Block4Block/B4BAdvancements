package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class PickupPlayerHeadAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_pickupplayerhead";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), CollectMobHeadAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Headhunter");
            x.setDescription("Pick up another player's head.");
            x.setIcon(Material.PLAYER_HEAD);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
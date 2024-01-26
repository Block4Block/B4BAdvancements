package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class PutMasterBookInEnderChestAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_putmasterbookinenderchest";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), CopyMasterBookCopyAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Safekeeping");
            x.setDescription("Put an original Master Book in an Ender Chest.");
            x.setIcon(Material.ENDER_CHEST);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
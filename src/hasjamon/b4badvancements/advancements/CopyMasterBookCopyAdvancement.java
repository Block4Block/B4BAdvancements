package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class CopyMasterBookCopyAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_copymasterbookcopy";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), CopyMasterBookAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("I Heard You Like Copies");
            x.setDescription("Create a copy of copy of a Master Book.");
            x.setIcon(Material.ENCHANTED_BOOK);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
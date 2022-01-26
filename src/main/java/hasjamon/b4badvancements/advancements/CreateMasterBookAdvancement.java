package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class CreateMasterBookAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_createmasterbook";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), MakeWritableBookAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Master Book");
            x.setDescription("Sign your Claim Book to create a Master Book that updates its copies automatically.");
            x.setIcon(Material.ENCHANTED_BOOK);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class MakeWritableBookAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_makewritablebook";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), MakeBookAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Book'n'Quill");
            x.setDescription("Make a Book & Quill! Check /b4bhelp to learn how to claim chunks.");
            x.setIcon(Material.WRITABLE_BOOK);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
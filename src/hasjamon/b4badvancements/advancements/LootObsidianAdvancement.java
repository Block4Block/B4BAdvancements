package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class LootObsidianAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_lootobsidian";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), PlaceSkeletonSpawnerAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Obsidian Obtainer");
            x.setDescription("Grab Obsidian from a chest. (Can be found near unfinished portals)");
            x.setIcon(Material.OBSIDIAN);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class UseNewBlastFurnaceRecipeAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_usenewblastfurnacerecipeadvancement";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), SmeltCobblestoneAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Stone Blaster");
            x.setDescription("Smelt Cobblestone or Cobbled Deepslate using a Blast Furnace.");
            x.setIcon(Material.BLAST_FURNACE);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}
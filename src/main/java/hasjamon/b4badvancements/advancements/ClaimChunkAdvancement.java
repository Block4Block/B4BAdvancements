package hasjamon.b4badvancements.advancements;

import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class ClaimChunkAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_claimchunk";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);

        advancement.setParent(new NamespacedKey(context.getPlugin(), MakeLecternAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Lectern's Claim List");
            x.setDescription("Claim a chunk by placing a claim book on a lectern.");
            x.setIcon(Material.LECTERN);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}

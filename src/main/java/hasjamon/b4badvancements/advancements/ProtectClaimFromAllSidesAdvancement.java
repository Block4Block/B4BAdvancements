package hasjamon.b4badvancements.advancements;

import hasjamon.block4block.utils.utils;
import net.roxeez.advancement.Advancement;
import net.roxeez.advancement.AdvancementCreator;
import net.roxeez.advancement.Context;
import net.roxeez.advancement.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class ProtectClaimFromAllSidesAdvancement implements AdvancementCreator {
    public static final String ID = "b4b_protectclaimfromallsides";

    @Override
    public @NotNull Advancement create(@NotNull Context context) {
        Advancement advancement = new Advancement(context.getPlugin(), ID);
        int numProtectiveBlockFaces = utils.protectiveBlockFaces.size();

        advancement.setParent(new NamespacedKey(context.getPlugin(), ClaimChunkAdvancement.ID));
        advancement.setDisplay(x -> {
            x.setTitle("Cardinal Point Defense");
            x.setDescription("Protect a Claim Lectern from all " + numProtectiveBlockFaces + " directions.");
            x.setIcon(Material.COMPASS);
        });
        advancement.addCriteria("0", TriggerType.IMPOSSIBLE, trigger -> {});

        return advancement;
    }
}

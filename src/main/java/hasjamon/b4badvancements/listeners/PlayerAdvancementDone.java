package hasjamon.b4badvancements.listeners;

import hasjamon.b4badvancements.B4BAdvancements;
import hasjamon.b4badvancements.advancements.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;

public class PlayerAdvancementDone implements Listener {
    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerAdvancementDone(PlayerAdvancementDoneEvent e) {
        Player player = e.getPlayer();
        int points = 0;

        switch(e.getAdvancement().getKey().getKey()){
            case WelcomeMessageAdvancement.ID -> points = 1;
            case /**/B4BreakBlockFailAdvancement.ID -> points = 1;
            case /*  */BreakLogsFreelyAdvancement.ID -> points = 1;
            case /*    */BreakLeavesFreelyAdvancement.ID -> points = 1;
            case /*      */BreakCraftingTableFreelyAdvancement.ID -> points = 3;
            case /*        */BreakBedFreelyAdvancement.ID -> points = 3;
            case /*          */BreakNyliumFreelyAdvancement.ID -> points = 5;
            case /*            */SpreadNyliumAdvancement.ID -> points = 10;
            case /*          */BreakAndesiteAdvancement.ID -> points = 3;
            case /*    */PickFlowerAdvancement.ID -> points = 5;
            case /*      */PickAllFlowersAdvancement.ID -> points = 40;
            case /*        */CraftAllDyesAdvancement.ID -> points = 50;
            case /*      */PickupMelonSliceAdvancement.ID -> points = 5;
            case /*        */PickupPumpkinAdvancement.ID -> points = 5;
            case /*          */PickupCactusAdvancement.ID -> points = 5;
            case /*      */KillPolarBearGetIceAdvancement.ID -> points = 10;
            case /*        */KillMooshroomGetStuffAdvancement.ID -> points = 25;
            case /*          */PickupValuableRandomDropAdvancement.ID -> points = 300;
            case /*      */FishGetSpawnEggAdvancement.ID -> points = 20;
            case /*        */FishGetRareStuffAdvancement.ID -> points = 50;
            case /*    */BreakWithinGracePeriodAdvancement.ID -> points = 1;
            case /*  */KillPigGetDirtAdvancement.ID -> points = 1;
            case /*    */B4BreakDirtAdvancement.ID -> points = 3;
            case /*    */RemoveGrassAdvancement.ID -> points = 1;
            case /*      */KillEndermanGetGrassAdvancement.ID -> points = 10;
            case /*      */JumpOnFarmlandAdvancement.ID -> points = 1;
            case /*    */PickupFallingBlockAdvancement.ID -> points = 5;
            case /*      */PickupFlintAdvancement.ID -> points = 10;
            case /*        */HitDripstoneWithTridentAdvancement.ID -> points = 30;
            case /*      */PickupSpawnEggAdvancement.ID -> points = 10;
            case /*        */NameChickenAdvancement.ID -> points = 100;
            case /*        */PickupRareSpawnEggAdvancement.ID -> points = 20;
            case /*          */PickupSuperRareSpawnEggAdvancement.ID -> points = 30;
            case /*            */SpawnZombieHorseAdvancement.ID -> points = 100;
            case /*              */UseAllSpawnEggsAdvancement.ID -> points = 300;
            case /*      */KillRaiderGetClayAdvancement.ID -> points = 10;
            case /*    */HelpCmdAdvancement.ID -> points = 3;
            case /*      */BedCmdAdvancement.ID -> points = 3;
            case /*    */StandCenterOverworldAdvancement.ID -> points = 3;
            case /*      */StandCenterNetherAdvancement.ID -> points = 6;
            case /*        */StandCenterEndAdvancement.ID -> points = 12;
            case /*  */KillSkeletonGetStoneAdvancement.ID -> points = 5;
            case /*    */KillWitherSkeletonGetBlackstoneAdvancement.ID -> points = 10;
            case /*    */B4BreakStoneAdvancement.ID -> points = 5;
            case /*      */LotsOfCobblestoneAdvancement.ID -> points = 20;
            case /*      */SmeltCobblestoneAdvancement.ID -> points = 5;
            case /*      */PickupSpawnerAdvancement.ID -> points = 20;
            case /*        */PlaceSkeletonSpawnerAdvancement.ID -> points = 50;
            case /*          */LootObsidianAdvancement.ID -> points = 25;
            case /*    */CollectMobHeadAdvancement.ID -> points = 5;
            case /*      */PickupPlayerHeadAdvancement.ID -> points = 10;
            case /*        */DisguiseAdvancement.ID -> points = 30;
            case /*      */CollectAllMobHeadsAdvancement.ID -> points = 100;
            case /*        */PickupAllMobHeadsAdvancement.ID -> points = 1000;
            case /*    */KillEndMobGetEndItemAdvancement.ID -> points = 5;
            case PickupSugarCaneAdvancement.ID -> points = 3;
            case /**/MakePaperAdvancement.ID -> points = 3;
            case /*  */MakeBookAdvancement.ID -> points = 3;
            case /*    */MakeWritableBookAdvancement.ID -> points = 5;
            case /*      */CreateMasterBookAdvancement.ID -> points = 5;
            case /*        */CopyMasterBookAdvancement.ID -> points = 3;
            case /*          */CopyMasterBookCopyAdvancement.ID -> points = 3;
            case /*            */PutMasterBookInEnderChestAdvancement.ID -> points = 10;
            case /*    */MakeLecternAdvancement.ID -> points = 3;
            case /*      */ClaimChunkAdvancement.ID -> points = 5;
            case /*        */BlockBreakInClaimAdvancement.ID -> points = 2;
            case /*        */IntruderAlertAdvancement.ID -> points = 5;
            case /*        */CreateClaimMapAdvancement.ID -> points = 5;
            case /*        */LoseClaimWhileOfflineAdvancement.ID -> points = 5;
            case /*        */BuildIronGolemAdvancement.ID -> points = 20;
            case /*        */ClaimContestChunkAdvancement.ID -> points = 25;
            case /*          */WinClaimContestAdvancement.ID -> points = 125;
            case /*        */FailBlockPlaceInClaimAdvancement.ID -> points = 3;
            case /*          */RemoveClaimAdvancement.ID -> points = 3;
            case /*        */Claim5ChunksAdvancement.ID -> points = 5;
            case /*          */Claim10ChunksAdvancement.ID -> points = 10;
            case /*            */Claim25ChunksAdvancement.ID -> points = 15;
            case /*              */Claim50ChunksAdvancement.ID -> points = 20;
            case /*                */Claim100ChunksAdvancement.ID -> points = 25;
            case /*                  */Claim250ChunksAdvancement.ID -> points = 30;
            case /*                    */Claim500ChunksAdvancement.ID -> points = 35;
            case /*                      */Claim1000ChunksAdvancement.ID -> points = 40;
            case /*                        */Claim10000ChunksAdvancement.ID -> points = 45;
            case /*                          */Claim100000ChunksAdvancement.ID -> points = 50;
        }

        if(points > 0) {
            player.sendMessage("§7You receive §6" + points + " points§7 for your most recent advancement!");
            B4BAdvancements.givePoints(player, points);
        }
    }
}
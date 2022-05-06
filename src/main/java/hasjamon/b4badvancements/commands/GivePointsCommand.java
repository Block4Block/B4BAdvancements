package hasjamon.b4badvancements.commands;

import hasjamon.b4badvancements.B4BAdvancements;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

import java.util.Arrays;
import java.util.Optional;

public class GivePointsCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(B4BAdvancements.canGivePoints) {
            if (args.length == 2) {
                if (sender instanceof ConsoleCommandSender) {
                    Optional<OfflinePlayer> recipient =
                            Arrays.stream(Bukkit.getOfflinePlayers())
                                    .filter(p -> p.getName() != null && p.getName().equalsIgnoreCase(args[0]))
                                    .findFirst();

                    if (recipient.isPresent()) {
                        if (args[1].matches("[0-9]+")) {
                            int amount = Integer.parseInt(args[1]);

                            sender.sendMessage("Sending " + amount + " points to " + recipient.get() + "...");
                            B4BAdvancements.givePoints(recipient.get(), amount);

                            return true;
                        } else {
                            sender.sendMessage("Error: The second argument must be an integer.");
                        }
                    } else {
                        sender.sendMessage("Error: The first argument must be the name of a player.");
                    }
                } else {
                    sender.sendMessage("Error: This command can only be used from the console.");
                }
            } else {
                sender.sendMessage("Error: Expected 2 arguments, got " + args.length);
            }
        }else{
            sender.sendMessage("Error: canGivePoints is false; do you have the Pay4PlayersAPI plugin?");
        }
        return false;
    }
}
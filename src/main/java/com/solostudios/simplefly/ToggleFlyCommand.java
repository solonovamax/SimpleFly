package com.solostudios.simplefly;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;


public class ToggleFlyCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You need to be a player to toggle flight.");
            return false;
        }
        Player player = (Player) sender;
        if (args.length == 1) {
            switch (args[0].toLowerCase()) {
                case "on":
                case "true":
                    player.setAllowFlight(true);
                    player.sendMessage("Enabled Fly");
                    break;
                case "off":
                case "false":
                    player.setAllowFlight(false);
                    player.sendMessage("Disabled Fly");
                    break;
                default:
                    return false;
            }
        } else if (args.length == 0) {
            player.setAllowFlight(!player.getAllowFlight());
            player.sendMessage(player.getAllowFlight() ? "Enabled Fly" : "Disabled Fly");
        } else {
            return false;
        }
        return true;
    }
    
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            return Arrays.asList("on", "off", "true", "false");
        } else {
            return null;
        }
    }
}

package fr.alphao.promomc.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class co implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            double x = p.getLocation().getBlockX();
            double y = p.getLocation().getBlockY();
            double z = p.getLocation().getBlockZ();
            if (args.length == 0) {
                p.sendMessage(ChatColor.GRAY + "Vos coordonnées : " + ChatColor.GREEN + x + " " + y + " " + z + ChatColor.GRAY + ".");
            }
            else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("bc")) {
                    Bukkit.broadcastMessage(ChatColor.GRAY + "Coordonnées de " + ChatColor.GREEN + p.getName() + ChatColor.GRAY + " : " + ChatColor.GREEN + x + " " + y + " " + z + ChatColor.GRAY + ".");
                }
                else {
                    p.sendMessage(ChatColor.GRAY + "Argument inconnu.");
                }
            }
            else if (args.length == 2 || args.length > 2 ) {
                if (args[0].equalsIgnoreCase("bc")) {
                    String reason = "";
                    for (final String arg : args) {
                        reason = String.valueOf(reason) + arg + " ";
                    }
                    Bukkit.broadcastMessage(ChatColor.GRAY + "Coordonnées de " + ChatColor.GREEN + p.getName() + ChatColor.GRAY + " : " + ChatColor.GREEN + x + " " + y + " " + z + ChatColor.GRAY + ", raison : " + ChatColor.GREEN + reason + ChatColor.GRAY + ".");
                }
            }
            else {
                p.sendMessage(ChatColor.GRAY + "Ne mettez pas plus d'arguments.");
            }
        }
        return false;
    }
}
package fr.alphao.promomc.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class sunny implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if (args.length == 0) {
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "weather clear 1800");
                Bukkit.broadcastMessage(ChatColor.GREEN + p.getName() + ChatColor.GRAY + " a mis le beau temps !");
            }
            else {
                p.sendMessage(ChatColor.GRAY + "Ne mettez pas plus d'arguments.");
            }
        }
        return false;
    }
}
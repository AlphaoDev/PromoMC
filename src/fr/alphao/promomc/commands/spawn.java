package fr.alphao.promomc.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class spawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if (args.length == 0) {
                World world = Bukkit.getWorld("world");
                Location loc = new Location(world, -180.5, 71, 86.5);
                p.teleport(loc);
                p.sendMessage(ChatColor.GRAY + "Vous avez été TP au spawn !");
            }
            else {
                p.sendMessage(ChatColor.GRAY + "Ne mettez pas plus d'arguments.");
            }
        }
        return false;
    }
}
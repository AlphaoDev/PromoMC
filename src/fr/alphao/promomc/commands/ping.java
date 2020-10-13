package fr.alphao.promomc.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_16_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class ping implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if (args.length == 0) {
                int playerping = ((CraftPlayer) p).getHandle().ping;
                p.sendMessage(ChatColor.GRAY + "Votre ping : " + ChatColor.GREEN + playerping + ChatColor.GRAY + "ms.");
            }
            else if (args.length == 1) {
                if (p.isOp()) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target == null) {
                        p.sendMessage(ChatColor.GRAY + "Joueur non trouvé.");
                    }
                    else {
                        int targetPing = ((CraftPlayer) target).getHandle().ping;
                        p.sendMessage(ChatColor.GRAY + "Ping de " + ChatColor.GREEN + target.getName() + ChatColor.GRAY + " : " + ChatColor.GREEN + targetPing + ChatColor.GRAY + "ms.");
                    }
                }
                else {
                    p.sendMessage(ChatColor.GRAY + "Vous n'avez pas la permission.");
                }
            }
            else {
                p.sendMessage(ChatColor.GRAY + "Ne mettez pas plus d'arguments.");
            }
        }
        return false;
    }
}
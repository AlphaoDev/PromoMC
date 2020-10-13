package fr.alphao.promomc.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class help implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if (args.length == 0) {
                p.sendMessage("");
                p.sendMessage(ChatColor.GRAY.BOLD + "Bienvenue sur le serveur de la Promo !" + "\n"
                        + ChatColor.GRAY + "> Ping : " + ChatColor.GREEN + "/ping" + "\n"
                        + ChatColor.GRAY + "> Coordonnées : " + ChatColor.GREEN + "/co [bc] [raison]" + "\n"
                        + ChatColor.GRAY + "> Beau temps : " + ChatColor.GREEN + "/sunny" + "\n"
                        + ChatColor.GRAY + "> Spawn : " + ChatColor.GREEN + "/spawn" + "\n"
                        + ChatColor.GRAY + "> Home : " + ChatColor.GREEN + "/sethome, /home" + "\n"
                        + ChatColor.RED + "⚠ Vous n'avez qu'un seul home !" + "\n"
                        + ChatColor.GRAY + "> Help : " + ChatColor.GREEN + "Affiche cet aide." + "\n"
                        + ChatColor.GRAY +"Une commande suprise est à trouvée :D" + "\n"
                );
                p.sendMessage("");
                p.sendMessage(ChatColor.GRAY + "Le mobgriefing est désactivé." + "\n" + "\n"
                        + ChatColor.RED + ChatColor.BOLD + "COMING SOON : " + ChatColor.GREEN + "Nouveau spawn" + "\n" + "\n"
                        + ChatColor.GRAY + "Règles : " + ChatColor.GREEN + "Ne pas détruire les bases des autres (sauf si consentement)" + ChatColor.GRAY + "."
                );
                p.sendMessage("");
            }
            else {
                p.sendMessage(ChatColor.GRAY + "Ne mettez pas plus d'arguments.");
            }
        }
        return false;
    }
}
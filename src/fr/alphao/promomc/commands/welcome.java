package fr.alphao.promomc.commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class welcome implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.getPlayer().sendMessage("");
        e.getPlayer().sendMessage(ChatColor.GRAY.BOLD + "Bienvenue sur le serveur de la Promo !" + "\n"
                        + ChatColor.GRAY + "> Ping : " + ChatColor.GREEN + "/ping" + "\n"
                        + ChatColor.GRAY + "> Coordonnées : " + ChatColor.GREEN + "/co [bc] [raison]" + "\n"
                        + ChatColor.GRAY + "> Beau temps : " + ChatColor.GREEN + "/sunny" + "\n"
                        + ChatColor.GRAY + "> Spawn : " + ChatColor.GREEN + "/spawn" + "\n"
                        + ChatColor.GRAY + "> Home : " + ChatColor.GREEN + "/sethome, /home" + "\n"
                        + ChatColor.RED + "⚠ Vous n'avez qu'un seul home !" + "\n"
                        + ChatColor.GRAY + "> Help : " + ChatColor.GREEN + "Affiche cet aide." + "\n"
                        + ChatColor.GRAY +"Une commande suprise est à trouvée :D" + "\n"
        );
        e.getPlayer().sendMessage("");
        e.getPlayer().sendMessage(ChatColor.GRAY + "Le mobgriefing est désactivé." + "\n" + "\n"
                        + ChatColor.RED + ChatColor.BOLD + "COMING SOON : " + ChatColor.GREEN + "Nouveau spawn" + "\n" + "\n"
                        + ChatColor.GRAY + "Règles : " + ChatColor.GREEN + "Ne pas détruire les bases des autres (sauf si consentement)" + ChatColor.GRAY + "."
        );
        e.getPlayer().sendMessage("");
    }
}

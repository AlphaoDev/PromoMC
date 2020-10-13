package fr.alphao.promomc.commands;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class join implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        e.getPlayer().setPlayerListName(ChatColor.GRAY + "[" + e.getPlayer().getName() + "] " + ChatColor.GREEN + e.getPlayer().getDisplayName());
    }
}

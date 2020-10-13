package fr.alphao.promomc.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class respawn implements Listener {

    @EventHandler
    public void onRespawn(PlayerRespawnEvent e) {
        Player p = e.getPlayer();
        p.sendMessage(ChatColor.GRAY+"Tu es mort et tu as été TP au spawn !");
        World world = p.getWorld();
        Location loc = new Location(world, -180.5, 71, 86.5);
        e.setRespawnLocation(loc);
    }
}

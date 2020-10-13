package fr.alphao.promomc;

import fr.alphao.promomc.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this);
        getLogger().info("PromoMC s'allume.");
        CommandExecutor co = (CommandExecutor) new co();
        getCommand("co").setExecutor(co);
        CommandExecutor ping = (CommandExecutor) new ping();
        getCommand("ping").setExecutor(ping);
        CommandExecutor sunny = (CommandExecutor) new sunny();
        getCommand("sunny").setExecutor(sunny);
        CommandExecutor spawn = (CommandExecutor) new spawn();
        getCommand("spawn").setExecutor(spawn);
        CommandExecutor hat = (CommandExecutor) new hat();
        getCommand("hat").setExecutor(hat);
        CommandExecutor help = (CommandExecutor) new help();
        getCommand("help").setExecutor(help);

        getServer().getPluginManager().registerEvents((Listener) new welcome(), this);
        getServer().getPluginManager().registerEvents((Listener) new respawn(), this);
        getServer().getPluginManager().registerEvents((Listener) new join(), this);
        getServer().getPluginManager().registerEvents((Listener) new co(), this);
        getServer().getPluginManager().registerEvents((Listener) new sunny(), this);
        getServer().getPluginManager().registerEvents((Listener) new spawn(), this);
        getServer().getPluginManager().registerEvents((Listener) new hat(), this);
        getServer().getPluginManager().registerEvents((Listener) new help(), this);

    }

    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.GRAY + "Seul les joueurs peuvent faire la commande.");
            return true;
        }
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("nick")) {
            if (args.length == 0) {
                p.sendMessage(ChatColor.GRAY + "Votre pseudo a été mis à jour.");
                this.getConfig().set(p.getName(), (Object)p.getName());
                this.saveConfig();
                return true;
            }
            String nick = "";
            for (final String arg : args) {
                nick = String.valueOf(nick) + arg + " ";
            }
            nick = nick.substring(0, nick.length() - 1);
            nick = nick.replaceAll("&", "§");
            p.sendMessage(ChatColor.GRAY + "Tu as changé ton pseudo en : " + ChatColor.GREEN + nick);
            this.getConfig().set(p.getName(), (Object)nick);
            this.saveConfig();
        }
        return true;
    }

    @EventHandler
    public void onPlayerChat(final AsyncPlayerChatEvent e) {
        if (this.getConfig().getString(e.getPlayer().getName()) != null) {
            e.getPlayer().setDisplayName(String.valueOf(this.getConfig().getString(e.getPlayer().getName())) + ChatColor.RESET);
            e.setFormat(ChatColor.GREEN + "[" + e.getPlayer().getName() + "] " + e.getPlayer().getDisplayName() + ChatColor.GRAY + " : " + e.getMessage());
        }
    }


//    @EventHandler
//    public void PlayerJoin(PlayerLoginEvent event) {
//        Player p = event.getPlayer();
//        if (!p.hasPlayedBefore()) {
//            World world = p.getWorld();
//            Location loc = new Location(world, -180.5, 71, 86.5);
//            p.teleport(loc);
//            p.sendMessage(ChatColor.GRAY + "Vous avez été TP au spawn !");
//        }
//    }

    @Override
    public void onDisable() {
        getLogger().info("PromoMC s'éteint.");
    }

}
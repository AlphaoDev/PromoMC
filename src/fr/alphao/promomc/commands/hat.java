package fr.alphao.promomc.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class hat implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if (args.length == 0) {
                final ItemStack hand = p.getItemInHand();
                final ItemStack head = p.getInventory().getHelmet();

                if(hand == null || hand.getType() == Material.AIR) {
                    p.sendMessage( ChatColor.GRAY + "Tu dois avoir un item dans ta main.");
                    return true;
                }
                else {
                    p.getInventory().setHelmet(hand);
                    p.getInventory().remove(hand);
                    p.sendMessage( ChatColor.GRAY + "Tu as mis ton chapeau chef !");
                }
                if(head != null || head.getType() != Material.AIR) {
                    p.getInventory().addItem(head);
                }
            }
            else {
                p.sendMessage(ChatColor.GRAY + "Ne mettez pas plus d'arguments.");
            }
        }
        return false;
    }
}
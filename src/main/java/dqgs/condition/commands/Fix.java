package dqgs.condition.commands;

import dqgs.condition.Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class Fix implements Listener, CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (command.getName().equalsIgnoreCase("fix")) {
                ItemStack item = Util.getItemInHand(player);
                short maxDurability =item.getType().getMaxDurability();

                item.setDurability(maxDurability);
                player.sendMessage(Util.getConfigPath("Fix"));
            }
        }
        return false; }
}

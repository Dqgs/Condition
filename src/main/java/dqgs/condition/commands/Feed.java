package dqgs.condition.commands;

import dqgs.condition.Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Feed implements Listener, CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (command.getName().equalsIgnoreCase("feed")) {
                if (player.hasPermission("condition.feed")) {
                    player.setFoodLevel(20);
                    player.setSaturation(2);
                    player.sendMessage(Util.getConfigPath("Feed"));
                }
            }
        }
        return false; }
}

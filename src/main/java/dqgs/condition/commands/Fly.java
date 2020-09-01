package dqgs.condition.commands;

import dqgs.condition.Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Fly implements Listener, CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (command.getName().equalsIgnoreCase("fly")) {
                if (isFlying(player)){
                    player.setAllowFlight(false);
                    player.sendMessage(Util.getConfigPath("FlightEnable"));
                } else {
                    player.setAllowFlight(true);
                    player.sendMessage(Util.getConfigPath("FlightDisable"));
                }
            }
        }
    return false; }

    public boolean isFlying(Player player){
        return player.getAllowFlight();
    }
}

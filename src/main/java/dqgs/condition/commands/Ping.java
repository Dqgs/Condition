package dqgs.condition.commands;

import dqgs.condition.Condition;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Random;

public class Ping implements Listener, CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (command.getName().equalsIgnoreCase("ping")) {
                player.sendMessage(Condition.getInstance().getConfig().getString("Ping").replace("%ping%", String.valueOf(getPing(player))));
            }
        }
        return false; }

    public int getPing(Player p) {
        int ping = new Random(50L).nextInt();
        try {
            Method getHandleMethod = p.getClass().getDeclaredMethod(
                    "getHandle", new Class[0]);
            getHandleMethod.setAccessible(true);
            Object nmsplayer = getHandleMethod.invoke(p, new Object[0]);
            Field pingField = nmsplayer.getClass().getDeclaredField("ping");
            pingField.setAccessible(true);
            ping = pingField.getInt(nmsplayer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ping;
    }
}

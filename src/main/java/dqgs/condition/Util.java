package dqgs.condition;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Util {
    public static String getConfigPath(String path){
        Condition.getInstance().getConfig().getString(path);
        return path;
    }
    public static ItemStack getItemInHand(Player player){
        ItemStack itemInHand = player.getInventory().getItemInHand();
        return itemInHand;
    }
}

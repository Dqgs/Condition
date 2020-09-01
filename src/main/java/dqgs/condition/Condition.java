package dqgs.condition;

import dqgs.condition.commands.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Condition extends JavaPlugin {

    private static Condition instance;

    @Override
    public void onEnable() {

        instance = this;

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        events();
        commands();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void events(){
        PluginManager server = Bukkit.getServer().getPluginManager();

        //server.registerEvents(new place(), this);
    }
    public void commands(){
        this.getCommand("fly").setExecutor(new Fly());
        this.getCommand("heal").setExecutor(new Heal());
        this.getCommand("feed").setExecutor(new Feed());
        this.getCommand("ping").setExecutor(new Ping());
        this.getCommand("fix").setExecutor(new Fix());
        this.getCommand("craft").setExecutor(new Craft());
    }

    public static Condition getInstance() {
        return instance;
    }
}

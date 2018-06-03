package net.ajzak.aotchlan;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main inst;
    public ConfigManager configManager;

    public void onEnable(){
        Main.inst = this;
        saveDefaultConfig();
        configManager = new ConfigManager(this);
        configManager.load();
    }

    public static Main getInst() {
        return Main.inst;
    }

}

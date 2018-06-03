package net.ajzak.aotchlan;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main inst;

    public void onEnable(){
        Main.inst = this;
        saveDefaultConfig();
    }

    public static Main getInst() {
        return Main.inst;
    }

}

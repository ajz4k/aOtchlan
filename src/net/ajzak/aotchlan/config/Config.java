package net.ajzak.aotchlan.config;

import net.ajzak.aotchlan.Main;
import org.bukkit.configuration.file.FileConfiguration;

import java.lang.reflect.Field;

public class Config {

    private static final String prefix = "config.";

    public static String INVENTORY_NAME;
    public static String OPEN;
    public static String CLOSE;
    public static String IS_CLOSE;
    public static String REMOVE;

    public static void loadConfig() {
        try {
            Main.getInst(   ).saveDefaultConfig();
            final FileConfiguration c = Main.getInst().getConfig();
            for (final Field f : Config.class.getFields()) {
                if (c.isSet("config." + f.getName().toLowerCase().replace("_", "."))) {
                    f.set(null, c.get("config." + f.getName().toLowerCase().replace("_", ".")));
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveConfig() {
        try {
            final FileConfiguration c = Main.getInst().getConfig();
            for (final Field f : Config.class.getFields()) {
                c.set("config." + f.getName().toLowerCase().replace("_", "."), f.get(null));
            }
            Main.getInst().saveConfig();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void reloadConfig() {
        Main.getInst().reloadConfig();
        loadConfig();
        saveConfig();
    }


    static {
        Config.CLOSE = "";
        Config.INVENTORY_NAME = "";
        Config.IS_CLOSE = "";
        Config.REMOVE = "";
    }


}

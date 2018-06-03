package net.ajzak.aotchlan.managers;

import net.ajzak.aotchlan.Main;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.inventory.Inventory;
import sun.security.krb5.Config;

public class Manager {

    public static boolean opened = false;
    public static Inventory inv;

    static{
        inv = Bukkit.createInventory(null, 54, "§2§lOtchlan");
    }

    public static void clearItems(){
        inv.clear();
        for(World world : Bukkit.getWorlds()){
            for(Entity e : world.getEntities()){
                if (e.getType().equals(EntityType.DROPPED_ITEM)){
                    inv.addItem(((Item)e).getItemStack());
                    e.remove();
                }
            }
        }
        opened = true;
        Bukkit.broadcastMessage(Settings.getInst().OTCHLAN_OPEN);
        Bukkit.getScheduler().runTaskLaterAsynchronously(Main.getInst(), () -> {
            opened = false;
            Bukkit.broadcastMessage(Settings.getInst().OTCHLAN_CLOSE);
        }, 400L);
    }

}

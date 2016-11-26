package com.thorindev;

import com.thorindev.gui.InventoryGUI;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class DarwinMain extends JavaPlugin implements Listener {

    InventoryGUI gui;

    @Override
    public void onEnable() {
        getLogger().info("DarwinMain has been enabled");
    }

    @Override
    public void onDisable() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        switch(cmd.getName().toLowerCase()) {
            case "gui":
                gui = new InventoryGUI("GUI", 3, (clicker, menu, row, slot, item) -> {
                    if(item.getType().equals(Material.DIAMOND)) {
                        gui.setSlot(gui.getRow(1), 4, new ItemStack(Material.COAL), "&aIt has been changed to coal");
                    } else if(item.getType().equals(Material.COAL)) {
                        gui.setSlot(gui.getRow(1), 4, new ItemStack(Material.DIAMOND), "&aThis is a custom item name", "&cExample Lore");
                    }
                    gui.refresh(player);
                    return true;
                });
                gui.setSlot(gui.getRow(1), 4, new ItemStack(Material.DIAMOND), "&aThis is a custom item name", "&cExample Lore");
                gui.open(player);
                break;
            default:
                player.sendMessage(ChatColor.GREEN + "I don't have code for that command");
                break;
        }
        return true;
    }


}

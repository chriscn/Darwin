package com.thorindev;

import com.thorindev.gui.InventoryGUI;
import com.thorindev.item.CustomColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class DarwinMain extends JavaPlugin implements Listener {

    InventoryGUI gui;
    InventoryGUI testGUI;

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
        if(cmd.getName().equalsIgnoreCase("gui")) {
            gui = new InventoryGUI("&cGUI", 3, (clicker, menu, row, slot, item) -> {
                if(item.getType().equals(Material.DIAMOND)) {
                    gui.setSlot(gui.getRow(1), 4, new ItemStack(Material.COAL),  "&aIt has been changed to coal",  "&cExample Lore #1",  "&bExample Lore #2");
                } else if(item.getType().equals(Material.COAL)) {
                    gui.setSlot(gui.getRow(1), 4, new ItemStack(Material.DIAMOND), "&aThis is a custom item name", "&cExample Lore");
                }
                gui.refresh(player);
                return true;
            });
            gui.setSlot(gui.getRow(1), 4, new ItemStack(Material.DIAMOND), "&aThis is a custom item name", "&cExample Lore");
            gui.open(player);
            return true;
        } else if(cmd.getName().equalsIgnoreCase("toggle")) {
            CustomColor lime = CustomColor.LIME;
            CustomColor gray = CustomColor.GRAY;
            ItemStack grayDye = new ItemStack(Material.INK_SACK, 1, gray.getData());
            ItemStack limeDye = new ItemStack(Material.INK_SACK, 1, lime.getData());
            testGUI = new InventoryGUI("&aTest GUI", 3, (clicker, menu, row, slot, item) -> {
                if(item.getType().equals(Material.INK_SACK)) {
                    if(item.equals(grayDye)) {
                        testGUI.setSlot(testGUI.getRow(1), 4, limeDye, "&aEnabled", "&7Click to disable");
                    } else if(item.equals(limeDye)) {
                        testGUI.setSlot(testGUI.getRow(1), 4, grayDye, "&cDisabled", "&7Click to enable");
                    }
                }
                testGUI.refresh(player);
                return true;
            });
            testGUI.setSlot(testGUI.getRow(1), 4, grayDye, "&cDisabled", "&7Click to enable");
            testGUI.open(player);
            return true;
        }
        return true;
    }

}

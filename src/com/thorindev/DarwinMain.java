package com.thorindev;

import com.thorindev.gui.InventoryGUI;
import com.thorindev.util.DyeColor;
import com.thorindev.util.GlassColor;
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
    InventoryGUI toggleGUI;

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

            DyeColor lime = DyeColor.LIME;
            DyeColor gray = DyeColor.GRAY;
            GlassColor lightBlue = GlassColor.LIGHT_BLUE;

            ItemStack grayDye = new ItemStack(Material.INK_SACK, 1, gray.getColor());
            ItemStack limeDye = new ItemStack(Material.INK_SACK, 1, lime.getColor());

            toggleGUI = new InventoryGUI("&aTest GUI", 4, (clicker, menu, row, slot, item) -> {
                if(item.getType().equals(Material.INK_SACK)) {
                    if(item.equals(grayDye)) {
                        toggleGUI.setSlot(toggleGUI.getRow(2), 4, limeDye, "&aEnabled", "&7Click to disable");
                        player.sendMessage(ChatColor.GREEN + "You enabled this");
                    } else if(item.equals(limeDye)) {
                        toggleGUI.setSlot(toggleGUI.getRow(2), 4, grayDye, "&cDisabled", "&7Click to enable");
                        player.sendMessage(ChatColor.RED + "You disabled this");
                    }
                }

                toggleGUI.refresh(player);
                return true;
            });
            toggleGUI.setSlot(toggleGUI.getRow(1), 4, new ItemStack(Material.STAINED_GLASS_PANE, 1, lightBlue.getColor()), "&aEnable or Disable");
            toggleGUI.setSlot(toggleGUI.getRow(2), 4, grayDye, "&cDisabled", "&7Click to enable");
            toggleGUI.open(player);
            return true;
        }
        return true;
    }

}

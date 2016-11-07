package com.thorindev.item;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GiveItem {

    public void giveItem(Player player, Material item, int amount) {
        ItemStack toGive = new ItemStack(item, amount);
        Inventory playerInventory = player.getInventory();
        playerInventory.addItem(toGive);
    }
}

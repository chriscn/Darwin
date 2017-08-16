package io.github.chriscn.entity;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Inventory {

    public ItemStack getItemInMainHand(Player player) {
        return new ItemStack(player.getInventory().getItemInMainHand());
    }

    public ItemStack getItemInOffHand(Player player) {
        return new ItemStack(player.getInventory().getItemInOffHand());
    }

}

package io.github.chriscn.player;

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

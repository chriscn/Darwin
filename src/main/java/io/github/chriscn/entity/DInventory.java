package io.github.chriscn.entity;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class DInventory {

    public ItemStack getItemInMainHand(Player player) {
        return new ItemStack(player.getInventory().getItemInMainHand());
    }

    public ItemStack getItemInOffHand(Player player) {
        return new ItemStack(player.getInventory().getItemInOffHand());
    }

    public void healPlayer(Player player) {
        player.setHealth(20F);
    }

    public void killPlayer(Player player) {
        player.setHealth(0F);
    }

}

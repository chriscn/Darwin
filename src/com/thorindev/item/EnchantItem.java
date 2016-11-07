package com.thorindev.item;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class EnchantItem {

    public void enchantItemInHand(Player player, Enchantment enchantment, int level) {
        ItemStack item = player.getInventory().getItemInMainHand();
        ItemStack air = new ItemStack(Material.AIR);
        if (item != air) {
            item.addEnchantment(enchantment, level);
        }
    }



}

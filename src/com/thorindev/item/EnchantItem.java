package com.thorindev.item;

public class EnchantItem {

    public void enchantItemInHand(Player player, Enchantment enchantment, int level) {
        ItemStack item = player.getInventory().getItemInMainHand();
        ItemStack air = new ItemStack(Material.AIR);
        if (item != air) {
            item.addEnchantment(enchantment, level);
        }
    }



}

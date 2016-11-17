package com.thorindev.player;

import net.minecraft.server.v1_10_R1.IChatBaseComponent;
import net.minecraft.server.v1_10_R1.PacketPlayOutChat;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Hotbar {

    public static void healPlayer(Player player) {
        player.setHealth(20);
    }

    public static void killPlayer(Player player) {
        player.setHealth(0);
    }

    public static void feedPlayer(Player player) {
        player.setFoodLevel(15);
    }

    public static void starvePlayer(Player player) {
        player.setFoodLevel(0);
    }

    public static static void sendActionBar(Player player, String message){
        message = message.toString();
        message = message.replaceAll("&", "§");
        CraftPlayer craftPlayer = (CraftPlayer) player;
        IChatBaseComponent cbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + message + "\"}");
        PacketPlayOutChat ppoc = new PacketPlayOutChat(cbc, (byte) 2);
        craftPlayer.getHandle().playerConnection.sendPacket(ppoc);
    }

    public static ItemStack getItemInMainHand(Player player) {
        ItemStack item = new ItemStack(player.getInventory().getItemInMainHand());
        return item;
    }

    public static ItemStack getItemInOffHand(Player player) {
        ItemStack item = new ItemStack(player.getInventory().getItemInOffHand());
        return item;
    }
}

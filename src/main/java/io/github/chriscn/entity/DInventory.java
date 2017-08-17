package io.github.chriscn.entity;

import net.minecraft.server.v1_11_R1.IChatBaseComponent;
import net.minecraft.server.v1_11_R1.PacketPlayOutChat;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftPlayer;
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

    public void feedPlayer(Player player) {
        player.setFoodLevel(15);
    }

    public void starvePlayer(Player player) {
        player.setFoodLevel(0);
    }

    public void sendActionBar(Player player, String message) {
        CraftPlayer craftPlayer = (CraftPlayer) player;
        IChatBaseComponent cbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + message.replaceAll("&", "§").toString() + "\"}");
        craftPlayer.getHandle().playerConnection.sendPacket(new PacketPlayOutChat(cbc, (byte) 2));
    }

}

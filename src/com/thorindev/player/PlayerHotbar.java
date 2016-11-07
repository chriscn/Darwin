package com.thorindev.player;

import net.minecraft.server.v1_10_R1.IChatBaseComponent;
import net.minecraft.server.v1_10_R1.PacketPlayOutChat;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class PlayerHotbar {

    public void healPlayer(Player player) {
        player.setHealth(20);
    }

    public void killPlayer(Player player) {
        player.setHealth(0);
    }

    public void feedPlayer(Player player) {
        player.setFoodLevel(15);
    }

    public void starvePlayer(Player player) {
        player.setFoodLevel(0);
    }

    public static void sendActionBar(Player player, String message){
        message = message.replaceAll("&", "§");
        CraftPlayer toSend = (CraftPlayer) player;
        IChatBaseComponent cbc = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + message + "\"}");
        PacketPlayOutChat ppoc = new PacketPlayOutChat(cbc, (byte) 2);
        toSend.getHandle().playerConnection.sendPacket(ppoc);
    }

}

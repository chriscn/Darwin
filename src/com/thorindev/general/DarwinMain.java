package com.thorindev.general;

import com.thorindev.entity.FireworkAPI;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class DarwinMain extends JavaPlugin implements Listener {

    FireworkAPI fw = new FireworkAPI();

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }


    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if(!player.hasPlayedBefore()) {
            player.sendMessage(ChatColor.GREEN + "Hello there! I see that you haven't played before, have a firework");
            fw.spawnRandomFirework(player);
        }
    }
}

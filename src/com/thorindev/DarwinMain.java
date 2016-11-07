package com.thorindev;

import com.thorindev.entity.EntityMain;
import com.thorindev.item.ItemMain;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Achievement;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class DarwinMain extends JavaPlugin implements Listener {

    EntityMain entityMain = new EntityMain();
    ItemMain itemMain = new ItemMain();

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
            entityMain.fireworkEntity.spawnRandomFirework(player);
        }
    }

    @EventHandler
    public void onPlayerGetAchievement(PlayerAchievementAwardedEvent event) {
        Player player = event.getPlayer();
        Achievement eventAchievement = event.getAchievement();
        if(event.getAchievement() == Achievement.OPEN_INVENTORY) {
            player.sendMessage(ChatColor.GREEN + "Well done for opening your inventory!");
            itemMain.giveItem.giveItem(player, Material.DIAMOND, 1);
        }
    }
}

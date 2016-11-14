package com.thorindev;

import com.thorindev.entity.FireworkSpawner;
import com.thorindev.player.Hotbar;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class DarwinMain extends JavaPlugin implements Listener {

    FireworkSpawner fireworkEntity = new FireworkSpawner();
    Hotbar hotbar = new Hotbar();

    @Override
    public void onEnable() {
        getLogger().info("DarwinMain has been enabled");
    }

    @Override
    public void onDisable() {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        switch(cmd.getName().toLowerCase()) {
            case "test":
                player.sendMessage(ChatColor.GREEN + "Your test was successful!");
                break;
            case "hotbar":
                hotbar.sendActionBar(player.getPlayer(), ChatColor.RED + "Hotbar messages are cool");
                break;
            case "fw":
                fireworkEntity.spawnRandomFirework(player);
                break;
            default:
                player.sendMessage(ChatColor.RED + "This a message letting you know that I have no idea what happened.");
                break;
        }
        return true;
    }

   @EventHandler
   public void onPlayerJoinEvent(PlayerJoinEvent event) {
       Player player = event.getPlayer();
       hotbar.sendActionBar(player, "Hello World");
   }
}

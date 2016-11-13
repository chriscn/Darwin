package com.thorindev;

import com.thorindev.entity.EntityMain;
import com.thorindev.item.ItemMain;
import com.thorindev.player.PlayerMain;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
<<<<<<< HEAD
import org.bukkit.event.player.PlayerJoinEvent;
=======
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
>>>>>>> origin/master
import org.bukkit.plugin.java.JavaPlugin;

public class DarwinMain extends JavaPlugin implements Listener {

    EntityMain entityMain = new EntityMain();
    ItemMain itemMain = new ItemMain();
    PlayerMain playerMain = new PlayerMain();

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
                playerMain.playerHotbar.sendActionBar(player.getPlayer(), ChatColor.RED + "Hotbar messages are cool");
                break;
            case "fw":
                entityMain.fireworkEntity.spawnRandomFirework(player);
                break;
            default:
                player.sendMessage(ChatColor.RED + "Something bad happened, your command was not found, have a good day!");
                break;
        }
        return true;
    }

   @EventHandler
   public void onPlayerJoinEvent(PlayerJoinEvent event) {
       Player player = event.getPlayer();
       playerMain.playerHotbar.sendActionBar(player, "Hello World");
   }
}

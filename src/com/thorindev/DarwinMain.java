package com.thorindev;

import com.thorindev.entity.EntityMain;
import com.thorindev.gui.InventoryGUI;
import com.thorindev.item.ItemMain;
import com.thorindev.player.PlayerMain;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Achievement;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class DarwinMain extends JavaPlugin implements Listener {

    EntityMain entityMain = new EntityMain();
    ItemMain itemMain = new ItemMain();
    PlayerMain playerMain = new PlayerMain();

    @Override
    public void onEnable() {

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
            case "gui":
                doTheGUIStuff();
                break;
            default:
                player.sendMessage(ChatColor.RED + "Something bad happened, your command was not found, have a good day!");
                break;
        }
        return true;
        /*} else if(cmd.getName().equalsIgnoreCase("gui")) {
            InventoryGUI gui = new InventoryGUI("IconMenu", 3, new InventoryGUI.onClick() {
                @Override
                public boolean click(Player p, InventoryGUI menu, InventoryGUI.Row row, int slot, ItemStack item) {
                    if(row.getRow() == 1) {
                        if(row.getRowItem(0).getType() == Material.STONE) {
                            row.getRowItem(0).setType(Material.ANVIL);
                        }
                    }
                    return true;
                }
            });
            gui.addButton(gui.getRow(1), 0, new ItemStack(Material.STONE), "Stone Button ;)");
            gui.addButton(gui.getRow(1), 1, new ItemStack(Material.WOOD), "Wood Button ;)");
            gui.addButton(gui.getRow(1), 2, new ItemStack(Material.DIAMOND), "Diamond Button ;)");
            gui.addButton(gui.getRow(1), 3, new ItemStack(Material.GOLD_BLOCK), "Gold Button ;)");
            gui.addButton(gui.getRow(1), 4, new ItemStack(Material.IRON_BLOCK), "Iron Button ;)");
            gui.addButton(gui.getRow(1), 5, new ItemStack(Material.OBSIDIAN), "Obby Button ;)");
            gui.addButton(gui.getRow(1), 6, new ItemStack(Material.ANVIL), "Anvil Button ;)");
            gui.addButton(gui.getRow(1), 7, new ItemStack(Material.STONE_BUTTON), "Button Button ;)");
            gui.addButton(gui.getRow(1), 8, new ItemStack(Material.PORTAL), "Portal Button ;)");
            gui.open(player.getPlayer());
        } */
    }

    private void doTheGUIStuff() {
        InventoryGUI gui = new InventoryGUI("Options", 1, new InventoryGUI.onClick() {
            @Override
            public boolean click(Player clicker, InventoryGUI menu, InventoryGUI.Row row, int slot, ItemStack item) {
                return false;
            }
        });

        gui.addButton(gui.getRow(1), 0, new ItemStack(Material.ANVIL));
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if(player.hasPlayedBefore()) {
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

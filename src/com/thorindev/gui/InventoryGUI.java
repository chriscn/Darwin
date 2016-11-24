package com.thorindev.gui;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InventoryGUI implements Listener {

    private String name;
    private int size;
    private onClick click;
    List<String> viewing = new ArrayList<>();

    private ItemStack[] items;

    public InventoryGUI(String name, int size, onClick click) {
        this.name = name;
        this.size = size * 9;
        items = new ItemStack[this.size];
        this.click = click;
        Bukkit.getPluginManager().registerEvents(this, Bukkit.getPluginManager().getPlugins()[0]);
    }

    @EventHandler
    public void onPluginDisable(PluginDisableEvent event) {
        for(Player player : this.getViewers()) {
            close(player);
        }
    }

    public InventoryGUI open(Player player) {
        player.openInventory(getInventory(player));
        viewing.add(player.getName());
        return this;
    }

    private Inventory getInventory(Player player) {
        Inventory inv = Bukkit.createInventory(player, size, name);
        for(int i = 0; i < items.length; i++) {
            if(items[i] != null)
                inv.setItem(i, items[i]);
        }
        return inv;
    }

    public InventoryGUI close(Player player) {
        if(player.getOpenInventory().getTitle().equals(name)) {
            player.closeInventory();
        }
        return this;
    }

    public List<Player> getViewers() {
        List<Player> viewers = new ArrayList<Player>();
        for(String s : viewing) {
            viewers.add(Bukkit.getPlayer(s));
        }
        return viewers;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if(viewing.contains(event.getWhoClicked().getName())) {
            event.setCancelled(true);
            Player player = (Player) event.getWhoClicked();
            Row row = getRowFromSlot(event.getSlot());
            if(!click.click(player, this, row, event.getSlot() - row.getRow() * 9, event.getCurrentItem())) {
                close(player);
            }
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        if(viewing.contains(event.getPlayer().getName())) {
            viewing.remove(event.getPlayer().getName());
        }
    }

    public InventoryGUI addButton(Row row, int position, ItemStack item, String name, String... lore) {
        name = ChatColor.translateAlternateColorCodes('&', name);
        items[row.getRow() * 9 + position] = getItem(item, name, lore);
        return this;
    }

    public Row getRowFromSlot(int slot) {
        return new Row(slot / 9, items);
    }

    public Row getRow(int row) {
        return new Row(row, items);
    }

    public interface onClick {
        public abstract boolean click(Player clicker, InventoryGUI menu, Row row, int slot, ItemStack item);
    }

    public class Row {
        private ItemStack[] rowItems = new ItemStack[9];
        int row;

        public Row(int row, ItemStack[] items) {
            this.row = row;
            int j = 0;
            for(int i = (row * 9); i < (row * 9) + 9; i++) {
                rowItems[j] = items[i];
                j++;
            }
        }

        public ItemStack[] getRowItems() {
            return rowItems;
        }

        public ItemStack getRowItem(int item) {
            return rowItems[item] == null ? new ItemStack(Material.AIR) : rowItems[item];
        }

        public int getRow() {
            return row;
        }
    }

    private ItemStack getItem(ItemStack item, String name, String... lore) {
        ItemMeta im = item.getItemMeta();
        im.setDisplayName(name);
        im.setLore(Arrays.asList(lore));
        item.setItemMeta(im);
        return item;
    }

}
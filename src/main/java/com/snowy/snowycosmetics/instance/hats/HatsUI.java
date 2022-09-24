package com.snowy.snowycosmetics.instance.hats;

import com.snowy.snowycosmetics.SnowyCosmetics;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class HatsUI {
    public HatsUI(SnowyCosmetics cosmetics, Player player) {
        Inventory inv = Bukkit.createInventory(null, 27, ChatColor.AQUA.toString() + ChatColor.BOLD + "Hats");



        player.openInventory(inv);
    }
}

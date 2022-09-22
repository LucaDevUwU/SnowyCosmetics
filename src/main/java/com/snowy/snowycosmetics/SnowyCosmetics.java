package com.snowy.snowycosmetics;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class SnowyCosmetics extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("cosmetics").setExecutor(new CosmeticsCommand());

        Bukkit.getPluginManager().registerEvents(new CosmeticListener(), this);
    }
}

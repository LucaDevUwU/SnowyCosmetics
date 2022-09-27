package com.snowy.snowycosmetics;

import com.snowy.snowycosmetics.instance.Cosmetic;
import com.snowy.snowycosmetics.navigation.CosmeticListener;
import com.snowy.snowycosmetics.navigation.CosmeticsCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public final class SnowyCosmetics extends JavaPlugin {

    private HashMap<UUID, List<Cosmetic>> activeCosmetics = new HashMap<>();

    @Override
    public void onEnable() {
        getCommand("cosmetics").setExecutor(new CosmeticsCommand());

        saveDefaultConfig();

        Bukkit.getPluginManager().registerEvents(new CosmeticListener(this), this);
    }

    public HashMap<UUID, List<Cosmetic>> getActiveCosmetics() { return activeCosmetics; }
}

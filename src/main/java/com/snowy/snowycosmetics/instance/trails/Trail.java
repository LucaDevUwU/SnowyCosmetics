package com.snowy.snowycosmetics.instance.trails;

import com.snowy.snowycosmetics.SnowyCosmetics;
import com.snowy.snowycosmetics.instance.Cosmetic;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public class Trail extends Cosmetic {
    private TrailType type;
    public Trail(SnowyCosmetics cosmetics, Player player, TrailType type) {
        super(cosmetics, player);
        this.type = type;
    }

    private BukkitTask task;
    @Override
    public void enable() {
        task = Bukkit.getScheduler().runTaskTimer(cosmetics, new Runnable() {
            Location location = player.getLocation();

            @Override
            public void run() {
                Location loc = player.getLocation();
                if (loc.getX() != location.getX() || loc.getZ() != location.getZ()) {
                    player.spawnParticle(type.getParticle(), player.getLocation(), 5);
                    location = player.getLocation();
                }
            }
        }, 0, 1);
    }

    @Override
    public void disable() {
        task.cancel();
    }

    public TrailType getType() { return type; }
}

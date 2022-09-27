package com.snowy.snowycosmetics.instance.trails;

import com.snowy.snowycosmetics.SnowyCosmetics;
import com.snowy.snowycosmetics.instance.Cosmetic;
import org.bukkit.entity.Player;

public class Trail extends Cosmetic {
    private TrailType type;
    public Trail(SnowyCosmetics cosmetics, Player player, TrailType type) {
        super(cosmetics, player);
        this.type = type;
    }

    @Override
    public void enable() {

    }

    @Override
    public void disable() {

    }
}

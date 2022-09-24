package com.snowy.snowycosmetics.instance;

import com.snowy.snowycosmetics.SnowyCosmetics;
import org.bukkit.entity.Player;

public abstract class Cosmetic {
    protected SnowyCosmetics cosmetics;
    protected Player player;

    public Cosmetic(SnowyCosmetics cosmetics, Player player) {
        this.cosmetics = cosmetics;
        this.player = player;
    }

    public abstract void enable();
    public abstract void disable();
}

package com.snowy.snowycosmetics.instance.trails;

import org.bukkit.ChatColor;
import org.bukkit.Particle;

import java.util.Arrays;
import java.util.List;

public enum TrailType {
    HEART_TRAIL(
            ChatColor.RED + "Heart Trail",
            Arrays.asList(ChatColor.GRAY + "lovely :3"),
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjEyNjZiNzQ4MjQyMTE1YjMwMzcwOGQ1OWNlOWQ1NTIzYjdkNzljMTNmNmRiNGViYzkxZGQ0NzIwOWViNzU5YyJ9fX0=",
            Particle.HEART),
    FLAME_TRAIL(
            ChatColor.GOLD + "Flame Trail",
            Arrays.asList(ChatColor.GRAY + "ooo~ :3"),
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWU1ZmM3Mzg3NTg5NWI1MmQ1MDZjZTllMzE5YzhiNzJjMjg5OWI4NjNkYjUzOGY1NmM2YjI4YzM1NDJhNjUwZCJ9fX0=",
            Particle.FLAME);

    private String display, headTexture;
    private List<String> description;
    private Particle particle;
    TrailType(String display, List<String> description, String headTexture, Particle particle) {
        this.display = display;
        this.description = description;
        this.headTexture = headTexture;
        this.particle = particle;
    }

    public String getDisplay() { return display; }
    public List<String> getDescription() { return description; }
    public String getHeadTexture() { return headTexture; }
    public Particle getParticle() { return particle; }
}


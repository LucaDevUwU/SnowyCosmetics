package com.snowy.snowycosmetics.instance.hats;

import org.bukkit.ChatColor;

import java.util.Arrays;
import java.util.List;

public enum HatType {
    TOP_HAT(
            ChatColor.RED + "Top Hat",
            Arrays.asList(ChatColor.GRAY + "Fancy :3"),
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjY5ZDM0ODI3ZDkwYTM1ZDY3YjcxOGRiYzJlNDI5YmQ5OTI0MTRiMTk3MTU1MTc4MTVhZDg2MzBiNDI0ZTlmMiJ9fX0="),
    TIGER_HAT(
            ChatColor.GOLD + "Tiger Hat",
            Arrays.asList(ChatColor.GRAY + "mrow :3"),
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTA5NWZjYzFlM2Q3Y2JkMzUwZjE5YjM4OTQ5OGFiOGJiOTZjNjVhZDE4NWQzNDU5MjA2N2E3ZDAzM2FjNDhkZSJ9fX0="),
    DOG_HAT(
            ChatColor.YELLOW + "Dog Hat",
            Arrays.asList(ChatColor.GRAY + "woof :3"),
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvY2Q4MzU0ZDgwZTE5ZWFkOWI4ZmY5ZDk3YjEyNTllYTliYTc4Zjk1MzBmNzJkZDAwY2I0M2QyY2VhZmExYmMwNSJ9fX0=");

    private String display, headTexture;
    private List<String> description;
    HatType(String display, List<String> description, String headTexture) {
        this.display = display;
        this.description = description;
        this.headTexture = headTexture;
    }

    public String getDisplay() { return display; }
    public List<String> getDescription() { return description; }
    public String getHeadTexture() { return headTexture; }
}

package com.snowy.snowycosmetics.instance.hats;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.snowy.snowycosmetics.SnowyCosmetics;
import com.snowy.snowycosmetics.instance.Cosmetic;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class HatsUI {
    public HatsUI(SnowyCosmetics cosmetics, Player player) {
        Inventory inv = Bukkit.createInventory(null, 27, ChatColor.AQUA.toString() + ChatColor.BOLD + "Hats");

        List<HatType> active = new ArrayList<>();
        if (cosmetics.getActiveCosmetics().containsKey(player.getUniqueId())) {
            for (Cosmetic cosmetic : cosmetics.getActiveCosmetics().get(player.getUniqueId())) {
                if (cosmetic instanceof Hat) {
                    active.add(((Hat) cosmetic).getType());
                    break;
                }
            }
        }



        List<String> owned = cosmetics.getConfig().getStringList(player.getUniqueId().toString()) != null ? cosmetics.getConfig().getStringList(player.getUniqueId().toString()) : new ArrayList<>();

        for (HatType type : HatType.values()) {
            ItemStack is = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta meta = (SkullMeta) is.getItemMeta();
            GameProfile profile = new GameProfile(UUID.randomUUID(), null);
            profile.getProperties().put("textures", new Property("textures", type.getHeadTexture()));
            Field field;
            try {
                field = meta.getClass().getDeclaredField("profile");
                field.setAccessible(true);
                field.set(meta, profile);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
                return;
            }
            if (owned.contains(type.name())) {
                meta.setDisplayName(type.getDisplay() + " " + (active.contains(type) ? ChatColor.RED + "[CLICK TO DISABLE]" : ChatColor.GREEN + "[CLICK TO ENABLE]"));
            } else {
                meta.setDisplayName(type.getDisplay());
            }
            meta.setLore(type.getDescription());
            meta.setLocalizedName(type.name());
            is.setItemMeta(meta);

            inv.addItem(is);
        }

        player.openInventory(inv);
    }
}

package com.snowy.snowycosmetics.navigation;

import com.snowy.snowycosmetics.SnowyCosmetics;
import com.snowy.snowycosmetics.instance.Cosmetic;
import com.snowy.snowycosmetics.instance.hats.Hat;
import com.snowy.snowycosmetics.instance.hats.HatType;
import com.snowy.snowycosmetics.instance.hats.HatsUI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CosmeticListener implements Listener {
    private SnowyCosmetics cosmetics;

    public CosmeticListener(SnowyCosmetics cosmetics) {
        this.cosmetics = cosmetics;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {

        Player player = (Player) e.getWhoClicked();
        if (e.getInventory() != null && e.getCurrentItem() != null) {
            if (e.getView().getTitle().endsWith("Cosmetics Menu!")) {
                if (e.getRawSlot() == 0) {
                    new HatsUI(cosmetics, player);
                }
            } else if (e.getView().getTitle().endsWith("Hats")) {
                HatType type = HatType.valueOf(e.getCurrentItem().getItemMeta().getLocalizedName());
                List<Cosmetic> active;
                if (cosmetics.getActiveCosmetics().containsKey(player.getUniqueId())) {
                    active = cosmetics.getActiveCosmetics().get(player.getUniqueId());
                    Iterator<Cosmetic> itr = active.listIterator();
                    while (itr.hasNext()) {
                        Cosmetic cosmetic = itr.next();
                        if (cosmetic instanceof Hat) {
                            cosmetic.disable();
                            itr.remove();

                            if (((Hat) cosmetic).getType() == type) {
                                player.sendMessage(ChatColor.RED + "You disabled " + type.getDisplay() + ".");
                                player.closeInventory();
                                return;
                            }
                        }
                    }
                } else {
                    active = new ArrayList<>();
                }
                Hat hat = new Hat(cosmetics, player, type);
                hat.enable();
                active.add(hat);
                cosmetics.getActiveCosmetics().put(player.getUniqueId(), active);

                player.sendMessage(ChatColor.GREEN.toString() + ChatColor.BOLD + "You enabled " + type.getDisplay() + " hat!");
                player.closeInventory();
            }
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();

        if (cosmetics.getActiveCosmetics().containsKey(player.getUniqueId())) {
            for (Cosmetic cosmetic : cosmetics.getActiveCosmetics().get(player.getUniqueId())) {
                cosmetic.disable();
            }
            cosmetics.getActiveCosmetics().remove(player.getUniqueId());
        }
    }
}

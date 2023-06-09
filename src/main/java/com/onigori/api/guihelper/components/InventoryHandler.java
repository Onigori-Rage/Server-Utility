package com.onigori.api.guihelper.components;

import com.onigori.api.guihelper.GUIHelper;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;

public class InventoryHandler implements Listener {

	@EventHandler
	public void onClick(InventoryClickEvent event) {
		final InventoryHolder holder = event.getInventory().getHolder();

		if (holder instanceof OnigoriScreen) {
			event.setCancelled(true);

			Bukkit.getScheduler().runTaskAsynchronously(GUIHelper.getPlugin(), () ->
				((OnigoriScreen) holder).fireHandler(event.getRawSlot(), (Player) event.getWhoClicked(), event.getClick())
			);

		}

	}

}

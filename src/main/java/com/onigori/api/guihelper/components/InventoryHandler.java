package com.onigori.api.guihelper.components;

import com.onigori.serverutility.objects.inventories.PunishScreen;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;

public class InventoryHandler implements Listener {

	@EventHandler
	public void onClick(InventoryClickEvent event) {
		InventoryHolder holder = event.getInventory().getHolder();

		if (holder instanceof OnigoriScreen) {
			event.setCancelled(true);



		}
	}

}

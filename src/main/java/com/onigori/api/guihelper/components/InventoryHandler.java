package com.onigori.api.guihelper.components;

import com.onigori.serverutility.SUtilMain;
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

			/*Bukkit.getScheduler().runTaskAsynchronously(GUIHelper.getPlugin(),
					() ->
			OnigoriScreen screen = (OnigoriScreen) holder;

			 */

		}
	}

}

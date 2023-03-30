package com.onigori.api.guihelper.components;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public abstract class OnigoriScreen implements InventoryHolder {

	private final Inventory inventory;

	public OnigoriScreen(int row, String name) {
		this.inventory = Bukkit.createInventory(null, row * 9, name);
		this.init();
	}

	public abstract void init();

	@Override
	public Inventory getInventory() {
		return this.inventory;
	}

}

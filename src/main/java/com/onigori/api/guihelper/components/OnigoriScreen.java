package com.onigori.api.guihelper.components;

import com.onigori.serverutility.players.SUtilPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public abstract class OnigoriScreen implements InventoryHolder {

	private final Inventory inventory;

	private static final ConcurrentHashMap<String, ConcurrentHashMap<Integer, ItemHandler>> HANDLERS = new ConcurrentHashMap<>();

	public OnigoriScreen(int row, String name) {
		this.inventory = Bukkit.createInventory(this, row * 9, name);
	}

	/*
	APIを改変
	 */
	public void execute(SUtilPlayer player, int slot) {
		HANDLERS.get(getClass().getName()).getOrDefault(slot, new EmptyHandler()).execute(player);
	}

	public static void addHandler(String className, ConcurrentHashMap<Integer, ItemHandler> handler) {
		HANDLERS.put(className, handler);
	}

	public abstract void init();

	@Override
	public Inventory getInventory() {
		return this.inventory;
	}

}

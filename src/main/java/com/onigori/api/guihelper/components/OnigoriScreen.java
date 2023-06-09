package com.onigori.api.guihelper.components;

import com.onigori.api.guihelper.OnigoriItem;
import com.onigori.serverutility.SUtilMain;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

import java.util.HashMap;

public abstract class OnigoriScreen implements InventoryHolder {

	private final Inventory inventory;

	private final HashMap<Integer, ItemHandler> handlersMap = new HashMap<>();

	private static final ItemHandler EMPTY_HANDLER = new EmptyHandler();

	public OnigoriScreen(int row, String name) {
		this.inventory = Bukkit.createInventory(this, row * 9, name);
	}

	public void setItem(OnigoriItem item, int... slots) {
		for (final int slot : slots) {
			this.inventory.setItem(slot, item.getItemStack());

			this.handlersMap.put(slot, item.getListener());
		}
	}

	public void fireHandler(final int slot, final Player player, final ClickType type) {
		this.handlersMap.getOrDefault(slot, EMPTY_HANDLER).execute(SUtilMain.getPlayerFactory().fetch(player.getUniqueId()), this, type);

	}

	public abstract void init();

	@Override
	public Inventory getInventory() {
		return this.inventory;
	}

}

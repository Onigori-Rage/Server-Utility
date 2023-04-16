package com.onigori.api.guihelper;

import com.onigori.api.guihelper.components.EmptyHandler;
import com.onigori.api.guihelper.components.ItemHandler;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class OnigoriItem {

	private final ItemStack itemStack;

	private ItemHandler handler = new EmptyHandler();

	public OnigoriItem(Material material, int amount) {
		this.itemStack = new ItemStack(material, amount);
	}

	public ItemStack getItemStack() {
		return this.itemStack;
	}

	public void setListener(ItemHandler handler) {
		this.handler = handler;
	}

	public ItemHandler getListener() {
		return this.handler;
	}

}

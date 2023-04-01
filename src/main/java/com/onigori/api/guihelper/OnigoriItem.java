package com.onigori.api.guihelper;

import com.onigori.api.guihelper.components.ItemHandler;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class OnigoriItem extends ItemStack {

	private ItemHandler handler;

	public OnigoriItem(Material type, int amount) {
		super(type, amount);
	}

	public final void setListener(ItemHandler handler) {
		this.handler = handler;
	}

}

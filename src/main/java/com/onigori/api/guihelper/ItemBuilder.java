package com.onigori.api.guihelper;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ItemBuilder {

	private ItemStack item;

	private ItemMeta meta;

	public ItemBuilder(Material material, int amount) {
		this.item = new ItemStack(material, amount);
		this.meta = this.item.getItemMeta();
	}

	public ItemBuilder setName(String name) {
		this.meta.setDisplayName(name);
		return this;
	}

	public ItemBuilder setDescription(String... lore) {
		this.meta.setLore(Arrays.asList(lore));
		return this;
	}

	public ItemStack build() {
		this.item.setItemMeta(this.meta);
		return this.item;
	}

}

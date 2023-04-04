package com.onigori.api.guihelper;

import com.onigori.api.guihelper.components.ItemHandler;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;
import java.util.UUID;

public class ItemBuilder {

	private OnigoriItem item;

	private ItemMeta meta;

	public ItemBuilder(Material material, int amount) {
		this.item = new OnigoriItem(material, amount);
		this.meta = this.item.getItemStack().getItemMeta();
	}

	public ItemBuilder setName(String name) {
		this.meta.setDisplayName(name);
		return this;
	}

	public ItemBuilder setDescription(String lore) {
		this.meta.setLore(Arrays.asList(lore.split("\n")));
		return this;
	}

	public ItemBuilder mergeSkull(UUID uuid) {
		((SkullMeta) this.meta).setOwningPlayer(Bukkit.getOfflinePlayer(uuid));

		this.item.getItemStack().setDurability((short) SkullType.PLAYER.ordinal());

		return this;
	}

	public ItemBuilder setListener(ItemHandler handler) {
		this.item.setListener(handler);

		return this;
	}

	public OnigoriItem build() {
		this.item.getItemStack().setItemMeta(this.meta);
		return this.item;
	}

}

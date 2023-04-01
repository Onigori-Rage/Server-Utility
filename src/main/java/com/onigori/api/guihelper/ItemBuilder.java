package com.onigori.api.guihelper;

import com.onigori.api.guihelper.components.ItemHandler;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;
import java.util.UUID;

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

	public ItemBuilder mergeSkull(UUID uuid) {
		((SkullMeta) this.meta).setOwningPlayer(Bukkit.getOfflinePlayer(uuid));

		this.item.setDurability((short) SkullType.PLAYER.ordinal());

		return this;
	}

	public ItemStack build() {
		this.item.setItemMeta(this.meta);
		return this.item;
	}

}

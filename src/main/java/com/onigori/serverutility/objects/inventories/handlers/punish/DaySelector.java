package com.onigori.serverutility.objects.inventories.handlers.punish;

import com.onigori.api.guihelper.GUIHelper;
import com.onigori.api.guihelper.components.ItemHandler;
import com.onigori.api.guihelper.components.OnigoriScreen;
import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.modules.LocalizedMessage;
import com.onigori.serverutility.objects.inventories.screens.PunishScreen;
import com.onigori.serverutility.objects.inventories.screens.punish.BanScreen;
import com.onigori.serverutility.players.SUtilPlayer;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DaySelector implements ItemHandler {

	@Override
	public void execute(SUtilPlayer player, OnigoriScreen screen, ClickType type) {

		PunishScreen punishScreen = (PunishScreen) screen;

		final int variation = punishScreen.adjustExpiration(type);



		/*
		動的
		 */
		ItemStack item = punishScreen.getInventory().getItem(0);
		ItemMeta meta = item.getItemMeta();

		meta.setLore(Arrays.asList(LocalizedMessage.getLocalizedMessage("gui-punish-expirationselector-lore", player.getLocale(), String.valueOf(variation)).split("\n")));

		item.setItemMeta(meta);

	}

}
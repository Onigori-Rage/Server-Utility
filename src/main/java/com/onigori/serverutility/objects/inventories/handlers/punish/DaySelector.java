package com.onigori.serverutility.objects.inventories.handlers.punish;

import com.onigori.api.guihelper.GUIHelper;
import com.onigori.api.guihelper.components.ItemHandler;
import com.onigori.api.guihelper.components.OnigoriScreen;
import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.objects.inventories.screens.punish.BanScreen;
import com.onigori.serverutility.players.SUtilPlayer;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DaySelector implements ItemHandler {

	@Override
	public void execute(SUtilPlayer player, OnigoriScreen screen, ClickType type) {
		if (!type.isRightClick()) {
			BanScreen banScreen = (BanScreen) screen;

			banScreen.days = banScreen.days + (type.isShiftClick() ? 14 : 1);

			ItemMeta meta = banScreen.getInventory().getItem(0).getItemMeta();
			meta.setLore(Arrays.asList(("§70日指定で永久になります。\n\n§71日増やす: §e左クリック\n§71日減らす: §e右クリック\n§7シフトを押しながらクリックで\n§72週間ごとの加減ができます。\n\n§6現在は " + banScreen.days + " 日").split("\n")));
			banScreen.getInventory().getItem(0).setItemMeta(meta);

		}

		else {
			BanScreen banScreen = (BanScreen) screen;

			if (banScreen.days == 0) {
				return;
			}

			banScreen.days = banScreen.days - (type.isShiftClick() ? 14 : 1);

			if (banScreen.days <= 0) {
				banScreen.days = 0;
			}

			ItemMeta meta = banScreen.getInventory().getItem(0).getItemMeta();
			meta.setLore(Arrays.asList(("§70日指定で永久になります。\n\n§71日増やす: §e左クリック\n§71日減らす: §e右クリック\n§7シフトを押しながらクリックで\n§72週間ごとの加減ができます。\n\n§6現在は " + banScreen.days + " 日").split("\n")));
			banScreen.getInventory().getItem(0).setItemMeta(meta);
		}

	}

}

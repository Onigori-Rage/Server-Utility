package com.onigori.serverutility.objects.inventories.handlers.punish;

import com.onigori.api.guihelper.GUIHelper;
import com.onigori.api.guihelper.components.ItemHandler;
import com.onigori.api.guihelper.components.OnigoriScreen;
import com.onigori.serverutility.objects.inventories.screens.PunishScreen;
import com.onigori.serverutility.objects.inventories.screens.punish.KickScreen;
import com.onigori.serverutility.players.SUtilPlayer;
import org.bukkit.event.inventory.ClickType;

public class KickOpener implements ItemHandler {

	@Override
	public void execute(SUtilPlayer player, OnigoriScreen screen, ClickType type) {
		GUIHelper.closeInventory(player.getCore());

		PunishScreen punishScreen = (PunishScreen) screen;

		GUIHelper.openInventory(new KickScreen(punishScreen.getExecutor(), punishScreen.getTarget(), punishScreen.getReason(), screen), player.getCore());
	}

}

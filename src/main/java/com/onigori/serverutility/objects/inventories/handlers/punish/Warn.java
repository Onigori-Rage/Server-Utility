package com.onigori.serverutility.objects.inventories.handlers.punish;

import com.onigori.api.guihelper.GUIHelper;
import com.onigori.api.guihelper.components.ItemHandler;
import com.onigori.api.guihelper.components.OnigoriScreen;
import com.onigori.serverutility.objects.inventories.screens.PunishScreen;
import com.onigori.serverutility.objects.inventories.screens.punish.WarnScreen;
import com.onigori.serverutility.players.SUtilPlayer;

public class Warn implements ItemHandler {

	@Override
	public void execute(SUtilPlayer player, OnigoriScreen screen) {
		GUIHelper.closeInventory(player.getCore());

		PunishScreen punishScreen = (PunishScreen) screen;

		GUIHelper.openInventory(new WarnScreen(punishScreen.getExecutor(), punishScreen.getTarget(), punishScreen.getReason()), player.getCore());
	}

}

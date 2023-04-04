package com.onigori.serverutility.objects.inventories.handlers;

import com.onigori.api.guihelper.GUIHelper;
import com.onigori.api.guihelper.components.ItemHandler;
import com.onigori.api.guihelper.components.OnigoriScreen;
import com.onigori.api.guihelper.components.TargetableScreen;
import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.objects.inventories.screens.TargetInfoScreen;
import com.onigori.serverutility.players.SUtilPlayer;
import org.bukkit.entity.Player;

public class TargetInfo implements ItemHandler {

	@Override
	public void execute(SUtilPlayer player, OnigoriScreen screen) {
		GUIHelper.closeInventory(player.getCore());

		TargetableScreen targetableScreen = (TargetableScreen) screen;

		GUIHelper.openInventory(new TargetInfoScreen(targetableScreen.getTarget(), player.getLocale(), screen), player.getCore());
	}

}

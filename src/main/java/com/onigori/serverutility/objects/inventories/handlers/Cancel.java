package com.onigori.serverutility.objects.inventories.handlers;

import com.onigori.api.guihelper.GUIHelper;
import com.onigori.api.guihelper.components.ItemHandler;
import com.onigori.api.guihelper.components.OnigoriScreen;
import com.onigori.serverutility.players.SUtilPlayer;

public class Cancel implements ItemHandler {

	@Override
	public void execute(SUtilPlayer player, OnigoriScreen screen) {
		GUIHelper.closeInventory(player.getCore());
		player.sendTranslated("You have closed the inventory", true);
	}

}

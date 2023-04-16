package com.onigori.serverutility.objects.inventories.handlers;

import com.onigori.api.guihelper.GUIHelper;
import com.onigori.api.guihelper.components.ItemHandler;
import com.onigori.api.guihelper.components.OnigoriScreen;
import com.onigori.api.guihelper.components.ReturnableScreen;
import com.onigori.serverutility.objects.players.SUtilPlayer;
import org.bukkit.event.inventory.ClickType;

public class Return implements ItemHandler {

	@Override
	public void execute(SUtilPlayer player, OnigoriScreen screen, ClickType type) {
		ReturnableScreen returnableScreen = (ReturnableScreen) screen;

		GUIHelper.closeInventory(player.getCore());

		GUIHelper.openInventory(returnableScreen.getPreviousScreen(), player.getCore());
	}

}

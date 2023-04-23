package com.onigori.serverutility.objects.inventories.handlers.punish;

import com.onigori.api.guihelper.GUIHelper;
import com.onigori.api.guihelper.components.ItemHandler;
import com.onigori.api.guihelper.components.OnigoriScreen;
import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.objects.inventories.screens.PunishScreen;
import com.onigori.serverutility.objects.inventories.screens.punish.ScreenType;
import com.onigori.serverutility.objects.players.SUtilPlayer;
import org.bukkit.event.inventory.ClickType;

public class PunishAccept implements ItemHandler {

	@Override
	public void execute(SUtilPlayer player, OnigoriScreen screen, ClickType type) {

		GUIHelper.closeInventory(player.getCore());

		PunishScreen punishScreen = (PunishScreen) screen;

		final int expiration = punishScreen.getExpiration();

		ScreenType screenType = punishScreen.getScreenType();
		String command = (expiration == 0 ? "" : "t") + screenType.name() + " " + punishScreen.getTarget().getName() + " " + (expiration == 0 ? "" : expiration + " ") + punishScreen.getReason();

		SUtilMain.getCommandHandler().dispatchCommand(player, command.split(" "), "punish");

	}

}

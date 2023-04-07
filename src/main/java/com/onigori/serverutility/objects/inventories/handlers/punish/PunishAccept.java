package com.onigori.serverutility.objects.inventories.handlers.punish;

import com.onigori.api.guihelper.GUIHelper;
import com.onigori.api.guihelper.components.ItemHandler;
import com.onigori.api.guihelper.components.OnigoriScreen;
import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.Symbols;
import com.onigori.serverutility.commands.CommandHandler;
import com.onigori.serverutility.modules.LocalizedMessage;
import com.onigori.serverutility.objects.inventories.screens.PunishScreen;
import com.onigori.serverutility.objects.inventories.screens.punish.KickScreen;
import com.onigori.serverutility.objects.inventories.screens.punish.ScreenType;
import com.onigori.serverutility.players.SUtilPlayer;
import org.bukkit.Bukkit;
import org.bukkit.event.inventory.ClickType;

public class PunishAccept implements ItemHandler {

	@Override
	public void execute(SUtilPlayer player, OnigoriScreen screen, ClickType type) {
		GUIHelper.closeInventory(player.getCore());

		PunishScreen punishScreen = (PunishScreen) screen;

		ScreenType screenType = punishScreen.getScreenType();
		String command = screenType.name() + " " + punishScreen.getTarget().getName() + " ";

		if (screenType == ScreenType.WARN || screenType == ScreenType.KICK) {
			command = command + punishScreen.getReason();
		}

		else {

			//TODO TempBan, Mute に対応する
			command = command + punishScreen.getReason();

		}

		SUtilMain.getCommandHandler().dispatchCommand(player, command.split(" "), "spunish");
	}

}

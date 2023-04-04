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
import com.onigori.serverutility.players.SUtilPlayer;
import org.bukkit.Bukkit;

public class PunishAccept implements ItemHandler {

	@Override
	public void execute(SUtilPlayer player, OnigoriScreen screen) {
		PunishScreen punishScreen = (PunishScreen) screen;

		GUIHelper.closeInventory(player.getCore());

		SUtilMain.getCommandHandler().dispatchCommand(player, new String[] {punishScreen.getScreenType().name()}, "spunish");

		/*Bukkit.getScheduler().runTask(SUtilMain.getInstance(), () ->
				kickScreen.getTarget().kick(LocalizedMessage.getLocalizedMessage("kick-reason", kickScreen.getTarget().getLocale(), Symbols.PREFIX, kickScreen.getReason()))
		);

		 */

	}

}

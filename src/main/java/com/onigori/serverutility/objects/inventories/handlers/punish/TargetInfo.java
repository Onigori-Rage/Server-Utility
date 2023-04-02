package com.onigori.serverutility.objects.inventories.handlers.punish;

import com.onigori.api.guihelper.components.ItemHandler;
import com.onigori.api.guihelper.components.OnigoriScreen;
import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.players.SUtilPlayer;
import org.bukkit.entity.Player;

public class TargetInfo implements ItemHandler {

	@Override
	public void execute(SUtilPlayer player, OnigoriScreen screen) {
		player.getCore().closeInventory();

		player.sendTranslated("§dNow developing...", true);
	}

}

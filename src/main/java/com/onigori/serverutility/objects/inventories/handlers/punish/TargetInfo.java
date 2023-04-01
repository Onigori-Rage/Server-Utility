package com.onigori.serverutility.objects.inventories.handlers.punish;

import com.onigori.api.guihelper.components.ItemHandler;
import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.players.SUtilPlayer;
import org.bukkit.entity.Player;

public class TargetInfo extends ItemHandler {

	@Override
	public void execute(SUtilPlayer player) {
		player.getCore().closeInventory();

		player.sendTranslated("You closed inventory", true);
	}

}

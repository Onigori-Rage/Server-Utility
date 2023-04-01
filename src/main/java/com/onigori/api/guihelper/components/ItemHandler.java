package com.onigori.api.guihelper.components;

import com.onigori.serverutility.SUtilMain;
import org.bukkit.entity.Player;

public class ItemHandler {

	public void execute(Player player) {
		SUtilMain.getPlayerFactory().fetch(player.getUniqueId()).sendTranslated("adadad", true);
	}

}

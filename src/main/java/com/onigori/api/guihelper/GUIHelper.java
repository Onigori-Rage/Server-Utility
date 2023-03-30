package com.onigori.api.guihelper;

import com.onigori.api.guihelper.components.OnigoriScreen;
import org.bukkit.entity.Player;

public class GUIHelper {

	/*
	This api helps you create spigot gui.
	Async.
	 */

	public static void openInventory(OnigoriScreen screen, Player player) {
		player.openInventory(screen.getInventory());
	}


}

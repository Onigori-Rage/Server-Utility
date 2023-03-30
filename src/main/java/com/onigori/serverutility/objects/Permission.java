package com.onigori.serverutility.objects;

import com.onigori.serverutility.SUtilMain;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public enum Permission {

	HIGHEST(100),
	NORMAL(0);

	private final int permission;

	Permission(int permission) {
		this.permission = permission;
	}

	public int getPermissionValue() {
		return this.permission;
	}

	/*
	Utilities.
	 */
	public static boolean comparedPermission(CommandSender sender, Permission permission) {
		Player player = (Player) sender;
		return SUtilMain.getPlayerFactory().fetch(player.getUniqueId()).getPermission().getPermissionValue() >= permission.getPermissionValue();
	}

}

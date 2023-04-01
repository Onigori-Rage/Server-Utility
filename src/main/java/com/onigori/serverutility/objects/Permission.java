package com.onigori.serverutility.objects;

import com.onigori.serverutility.commands.Sender;

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
	public static boolean comparedPermission(Sender sender, Permission permission) {
		return sender.getPermission().getPermissionValue() >= permission.getPermissionValue();
	}

}

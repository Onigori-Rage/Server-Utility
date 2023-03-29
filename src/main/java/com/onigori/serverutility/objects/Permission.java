package com.onigori.serverutility.objects;

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

}

package com.onigori.serverutility.objects.inventories.screens.punish;

public enum ScreenType {

	BOSS(5, "gui-punish-displayname"),
	KICK(3, "gui-punish-kick-displayname"),
	WARN(3, "gui-punish-warn-displayname"),
	BAN(3, "gui-punish-ban-displayname"),
	MUTE(3, "gui-punish-mute-displayname");

	private final int row;

	private final String displayKey;

	ScreenType(int row, String displayKey) {
		this.row = row;

		this.displayKey = displayKey;
	}

	public int getRow() {
		return this.row;
	}

	public String getDisplayKey() {
		return this.displayKey;
	}

}

package com.onigori.serverutility.objects.inventories;

import com.onigori.api.guihelper.components.OnigoriScreen;
import com.onigori.serverutility.players.SUtilPlayer;

public class PunishScreen extends OnigoriScreen {

	private final SUtilPlayer player;

	public PunishScreen(int row, String name, SUtilPlayer player) {
		super(row, name);
		this.player = player;
	}

	@Override
	public void init() {

	}

}

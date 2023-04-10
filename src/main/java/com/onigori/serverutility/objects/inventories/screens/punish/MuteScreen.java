package com.onigori.serverutility.objects.inventories.screens.punish;

import com.onigori.api.guihelper.components.OnigoriScreen;
import com.onigori.serverutility.objects.inventories.screens.PunishScreen;
import com.onigori.serverutility.players.SUtilPlayer;

public class MuteScreen extends PunishScreen {

	public MuteScreen(SUtilPlayer executor, SUtilPlayer target, String reason, ScreenType screenType, OnigoriScreen previousScreen) {
		super(executor, target, reason, screenType, previousScreen);
	}

	@Override
	public void init() {

	}

}

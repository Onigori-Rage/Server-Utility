package com.onigori.api.guihelper.components;

import com.onigori.serverutility.objects.players.SUtilPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.world.WorldInitEvent;

public class EmptyHandler implements ItemHandler {

	@Override
	public void execute(SUtilPlayer player, OnigoriScreen screen, ClickType type) {

	}

}

package com.onigori.api.guihelper.components;

import com.onigori.serverutility.objects.players.SUtilPlayer;
import org.bukkit.event.inventory.ClickType;

public interface ItemHandler {

	void execute(SUtilPlayer player, OnigoriScreen screen, ClickType type);

}

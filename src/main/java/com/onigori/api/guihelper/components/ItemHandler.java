package com.onigori.api.guihelper.components;

import com.onigori.serverutility.players.SUtilPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

public interface ItemHandler {

	void execute(SUtilPlayer player, OnigoriScreen screen, ClickType type);

}

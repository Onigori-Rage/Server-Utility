package com.onigori.serverutility.listeners;

import com.onigori.serverutility.SUtilMain;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitHandler implements Listener {

	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		SUtilMain.getPlayerFactory().fetch(event.getPlayer().getUniqueId()).updatePlayer(null);
	}

}

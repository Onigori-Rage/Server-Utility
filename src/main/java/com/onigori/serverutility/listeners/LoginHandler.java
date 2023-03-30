package com.onigori.serverutility.listeners;

import com.onigori.serverutility.SUtilMain;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class LoginHandler implements Listener {

	@EventHandler
	public void onPreLogin(AsyncPlayerPreLoginEvent event) {
		//TODO Add punish handling.
	}

	@EventHandler
	public void onLogin(PlayerLoginEvent event) {
		Player player = event.getPlayer();
		SUtilMain.getPlayerFactory().fetch(player.getUniqueId()).updatePlayer(player);
	}

}

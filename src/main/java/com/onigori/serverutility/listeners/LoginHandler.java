package com.onigori.serverutility.listeners;

import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.objects.punishments.Ban;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Calendar;

public class LoginHandler implements Listener {

	@EventHandler
	public void onPreLogin(AsyncPlayerPreLoginEvent event) {
		Ban ban = SUtilMain.getPlayerFactory().fetch(event.getUniqueId()).getPunishment().getAvailableBan();
		if (ban != null) {
			if (!ban.isTemporary() || ban.getExpire().after(Calendar.getInstance().getTime())) {
				event.setLoginResult(AsyncPlayerPreLoginEvent.Result.KICK_OTHER);
				event.setKickMessage("You are banned!");

				return;
			}

			SUtilMain.getPlayerFactory().fetch(event.getUniqueId()).getPunishment().setBan(null);

		}

	}

	@EventHandler
	public void onLogin(PlayerLoginEvent event) {
		Player player = event.getPlayer();
		SUtilMain.getPlayerFactory().fetch(player.getUniqueId()).updatePlayer(player);
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		SUtilMain.getPlayerFactory().fetch(event.getPlayer().getUniqueId()).updatePlayer(null);
	}

}

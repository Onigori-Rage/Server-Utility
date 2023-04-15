package com.onigori.serverutility.listeners;

import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.Symbols;
import com.onigori.serverutility.modules.LocalizedMessage;
import com.onigori.serverutility.objects.punishments.Ban;
import com.onigori.serverutility.players.SUtilPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class LoginListener implements Listener {

	@EventHandler
	public void onPreLogin(AsyncPlayerPreLoginEvent event) {
		final SUtilPlayer player = SUtilMain.getPlayerFactory().fetch(event.getUniqueId());

		final Ban ban = player.getPunishment().getAvailableBan();

		if (ban != null) {

			if (ban.checkExpiration()) {
				event.setLoginResult(AsyncPlayerPreLoginEvent.Result.KICK_OTHER);

				event.setKickMessage(LocalizedMessage.getLocalizedMessage("ban-message", player.getLocale(), Symbols.PREFIX, ban.getExecutor().getName(), ban.getReason(), ban.getExpirationAsString()));

				return;
			}

			SUtilMain.getPlayerFactory().fetch(event.getUniqueId()).getPunishment().setBan(null);

		}

	}

	@EventHandler
	public void onLogin(PlayerLoginEvent event) {
		final Player player = event.getPlayer();

		SUtilMain.getPlayerFactory().fetch(player.getUniqueId()).updatePlayer(player);
	}

}

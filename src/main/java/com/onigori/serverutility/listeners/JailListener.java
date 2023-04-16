package com.onigori.serverutility.listeners;

import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.Symbols;
import com.onigori.serverutility.objects.punishments.Jail;
import com.onigori.serverutility.objects.players.SUtilPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class JailListener implements Listener {

	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent event) {
		final SUtilPlayer player = SUtilMain.getPlayerFactory().fetch(event.getPlayer().getUniqueId());

		final Jail jail = player.getPunishment().getAvailableJail();

		if (jail == null) {
			return;
		}

		event.setCancelled(true);

		player.sendMessage("jail-message", true);

	}

}

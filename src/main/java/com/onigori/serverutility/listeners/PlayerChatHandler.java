package com.onigori.serverutility.listeners;

import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.objects.punishments.Mute;
import com.onigori.serverutility.players.SUtilPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChatHandler implements Listener {

	@EventHandler
	public void onAsyncChat(AsyncPlayerChatEvent event) {
		SUtilPlayer player = SUtilMain.getPlayerFactory().fetch(event.getPlayer().getUniqueId());

		Mute mute = player.getPunishment().getAvailableMute();

		if (mute.checkExpiration()) {
			event.setCancelled(true);

			player.sendTranslated("You are muted now!", true);
		}
	}

}

package com.onigori.serverutility.listeners;

import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.Symbols;
import com.onigori.serverutility.objects.punishments.Mute;
import com.onigori.serverutility.objects.players.SUtilPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

	@EventHandler(priority = EventPriority.MONITOR)
	public void onAsyncChat(AsyncPlayerChatEvent event) {
		final SUtilPlayer player = SUtilMain.getPlayerFactory().fetch(event.getPlayer().getUniqueId());

		final Mute mute = player.getPunishment().getAvailableMute();

		if (mute != null && mute.checkExpiration()) {
			event.setCancelled(true);

			player.sendMessage("mute-message", true, Symbols.PREFIX, mute.getExecutor().getName(), mute.getReason(), mute.getExpirationAsString());

			return;

		}

		final String prefix = player.getRank().getPrefix();

		event.setFormat(prefix + player.getName() + "§a: §f%2$s");
	}

}

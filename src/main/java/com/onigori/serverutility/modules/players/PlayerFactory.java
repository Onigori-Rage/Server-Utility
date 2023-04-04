package com.onigori.serverutility.modules.players;

import com.onigori.serverutility.objects.Permission;
import com.onigori.serverutility.players.Punishment;
import com.onigori.serverutility.players.SUtilPlayer;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class PlayerFactory {

	private final ConcurrentHashMap<UUID, SUtilPlayer> playerMap = new ConcurrentHashMap<>();

	public void init() {
	}

	public void stop() {

	}

	public SUtilPlayer fetch(UUID uuid) {
		SUtilPlayer player = this.playerMap.get(uuid);
		if (player == null) {
			player = this.addPlayer(uuid);
		}

		//SUtilMain.getSender().sendTranslated(uuid.toString(), true);

		return player;
	}

	public SUtilPlayer fetch(String name) {
		OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(name);
		return this.fetch(offlinePlayer.getUniqueId());
	}

	public SUtilPlayer addPlayer(UUID uuid) {
		OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(uuid);

		SUtilPlayer player = new SUtilPlayer(uuid, offlinePlayer.getName(), Permission.NORMAL, new Punishment());
		player.updatePlayer(offlinePlayer.getPlayer());

		return this.addPlayer(player);
	}

	public SUtilPlayer addPlayer(SUtilPlayer player) {
		playerMap.putIfAbsent(player.getUUID(), player);
		return player;
	}

}

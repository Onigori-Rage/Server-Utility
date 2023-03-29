package com.onigori.serverutility.modules.players;

import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.objects.IInit;
import com.onigori.serverutility.objects.Permission;
import com.onigori.serverutility.players.Punishment;
import com.onigori.serverutility.players.SUtilPlayer;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class PlayerFactory implements IInit {

	private final ConcurrentHashMap<UUID, SUtilPlayer> playerMap = new ConcurrentHashMap<>();

	@Override
	public void init() {
	}

	@Override
	public void stop() {

	}

	public SUtilPlayer fetch(UUID uuid) {
		SUtilPlayer player = this.playerMap.get(uuid);
		if (player == null) {
			player = this.addPlayer(uuid);
		}
		return player;
	}

	/*
	Warn
	 */
	public SUtilPlayer fetch(String name) {
		OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(name);

		return this.fetch(offlinePlayer.getUniqueId());
	}

	public SUtilPlayer addPlayer(UUID uuid) {
		return this.addPlayer(new SUtilPlayer(uuid, Bukkit.getOfflinePlayer(uuid).getName(), Permission.NORMAL, new Punishment()));
	}

	public SUtilPlayer addPlayer(SUtilPlayer player) {
		return playerMap.putIfAbsent(player.getUUID(), player);
	}

}

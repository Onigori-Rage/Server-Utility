package com.onigori.serverutility.modules.players;

import com.onigori.serverutility.Symbols;
import com.onigori.serverutility.modules.RankManager;
import com.onigori.serverutility.modules.SearchParser;
import com.onigori.serverutility.objects.players.PunishmentContainer;
import com.onigori.serverutility.objects.players.SUtilPlayer;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

import java.util.*;
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

	/*
	Very slow system.
	 */
	public Collection<SUtilPlayer> query(HashMap<SearchParser.Option, String> command) {

		Collection<SUtilPlayer> result = new HashSet<>(playerMap.values());

		for (Map.Entry<SearchParser.Option, String> entry : command.entrySet()) {
			result = entry.getKey().handle(result, entry.getValue());
		}

		return result;
	}

	public SUtilPlayer fetch(String name) {
		OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(name);
		return this.fetch(offlinePlayer.getUniqueId());
	}

	public SUtilPlayer addPlayer(UUID uuid) {
		OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(uuid);

		SUtilPlayer player = new SUtilPlayer(uuid, offlinePlayer.getName(), RankManager.getDefaultRank(), new PunishmentContainer());
		player.updatePlayer(offlinePlayer.getPlayer());

		return this.addPlayer(player);
	}

	public SUtilPlayer addPlayer(SUtilPlayer player) {
		playerMap.putIfAbsent(player.getUUID(), player);

		return player;
	}

}

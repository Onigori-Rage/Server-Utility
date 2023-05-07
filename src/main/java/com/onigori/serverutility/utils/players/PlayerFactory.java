package com.onigori.serverutility.utils.players;

import com.onigori.api.confighelper.Config;
import com.onigori.api.confighelper.ConfigHelper;
import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.Symbols;
import com.onigori.serverutility.objects.Rank;
import com.onigori.serverutility.objects.players.PunishmentContainer;
import com.onigori.serverutility.objects.players.SUtilPlayer;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.ConfigurationSection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class PlayerFactory {

	private final ConcurrentHashMap<UUID, SUtilPlayer> playerMap = new ConcurrentHashMap<>();

	public void init() {
		final Config playerConfig = ConfigHelper.getPlayerConfig();

		final ConfigurationSection section = playerConfig.getConfigSection("");

		if (section != null) {

			final RankManager rankManager = SUtilMain.getRankManager();

			for (String uuidString : section.getKeys(false)) {

				final UUID uuid = UUID.fromString(uuidString);

				final Rank rank = rankManager.getRankOrDefault(section.getString(uuidString + ".rank", "default"));

				final String name = section.getString(uuidString + ".name", null);

				final Locale locale = section.getString(uuidString + ".locale", Symbols.DEFAULT_LOCALE.getDisplayName(Locale.ENGLISH)).equalsIgnoreCase("Japanese") ? Locale.JAPANESE : Locale.ENGLISH;

				final SUtilPlayer player = new SUtilPlayer(uuid, name, rank, new PunishmentContainer());
				player.setLocale(locale);
				player.updatePlayer(Bukkit.getOfflinePlayer(uuid).getPlayer());

				this.addPlayer(player);

			}
		}

	}

	public void stop() {
		final Config playerConfig = ConfigHelper.getPlayerConfig();

		for (SUtilPlayer player : this.playerMap.values()) {

			playerConfig.set(player.getUUID().toString() + ".rank", player.getRank().getName());

			playerConfig.set(player.getUUID().toString() + ".locale", player.getLocale().getDisplayName(Locale.ENGLISH));

			playerConfig.set(player.getUUID().toString() + ".name", player.getName());
		}
	}

	public SUtilPlayer fetch(UUID uuid) {
		return this.playerMap.getOrDefault(uuid, this.addPlayer(uuid));
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
		return this.fetch(Bukkit.getOfflinePlayer(name).getUniqueId());
	}

	public SUtilPlayer addPlayer(UUID uuid) {
		final OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(uuid);

		final SUtilPlayer player = new SUtilPlayer(uuid, offlinePlayer.getName(), SUtilMain.getRankManager().getDefaultRank(), new PunishmentContainer());

		player.updatePlayer(offlinePlayer.getPlayer());

		return this.addPlayer(player);
	}

	public SUtilPlayer addPlayer(SUtilPlayer player) {
		playerMap.putIfAbsent(player.getUUID(), player);

		return player;
	}

}

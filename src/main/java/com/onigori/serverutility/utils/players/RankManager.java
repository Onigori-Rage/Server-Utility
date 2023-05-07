package com.onigori.serverutility.utils.players;

import com.onigori.api.confighelper.Config;
import com.onigori.api.confighelper.ConfigHelper;
import com.onigori.serverutility.objects.Rank;
import org.bukkit.configuration.ConfigurationSection;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

public class RankManager {

	private final ConcurrentHashMap<String, Rank> rankMap = new ConcurrentHashMap<>();

	private Rank DEFAULT_RANK;

	public void init() {

		final Config rankConfig = ConfigHelper.getRankConfig();

		final ConfigurationSection section = rankConfig.getConfigSection("");

		if (section != null) {

			for (String rankName : section.getKeys(false)) {

				final int value = section.getInt(rankName + ".value", 0);

				final Rank rank = new Rank(rankName, section.getString(rankName + ".prefix", ""), value);

				rankMap.put(rankName, rank);

				if (rankName.equals("default")) {
					DEFAULT_RANK = rank;
				}

			}

			return;
		}

		DEFAULT_RANK = new Rank("default", "", 0);

		rankMap.put("default", DEFAULT_RANK);

	}

	public void stop() {
		final Config rankConfig = ConfigHelper.getRankConfig();

		for (Rank rank : rankMap.values()) {
			if (rank.isToBeRemoved()) {
				rankConfig.set(rank.getName(), null);

				continue;
			}

			rankConfig.set(rank.getName() + ".value", rank.getValue());

			rankConfig.set(rank.getName() + ".prefix", rank.getRawPrefix());
		}
	}

	public void createRank(String name) {
		rankMap.put(name, new Rank(name, "", 0));
	}

	public void removeRank(String name) {
		rankMap.remove(name);
	}

	public Rank getRankOrDefault(String name) {
		return rankMap.getOrDefault(name, DEFAULT_RANK);
	}

	public Rank getRank(String name) {
		return rankMap.get(name);
	}

	public Rank getDefaultRank() {
		return DEFAULT_RANK;
	}

	public Collection<Rank> getRanks() {
		return rankMap.values();
	}

}

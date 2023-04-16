package com.onigori.serverutility.modules;

import com.onigori.api.confighelper.Config;
import com.onigori.api.confighelper.ConfigHelper;
import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.objects.Rank;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.ConfigurationSection;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class RankManager {

	private static final ConcurrentHashMap<String, Rank> RANKS = new ConcurrentHashMap<>();

	private static Rank DEFAULT_RANK;

	public static void init() {

		final Config rankConfig = ConfigHelper.getRankConfig();

		final ConfigurationSection section = rankConfig.getConfigSection("");

		if (section != null) {

			for (String rankName : section.getKeys(false)) {

				int value = section.getInt(rankName + ".value", 0);

				final Rank rank = new Rank(rankName, section.getString(rankName + ".prefix", ""), value);

				RANKS.put(rankName, rank);

				if (rankName.equals("default")) {
					DEFAULT_RANK = rank;
				}

			}

			return;
		}

		DEFAULT_RANK = new Rank("default", "", 0);

		RANKS.put("default", DEFAULT_RANK);

	}

	public static void stop() {
		final Config rankConfig = ConfigHelper.getRankConfig();

		for (Rank rank : RANKS.values()) {
			if (rank.isToBeRemoved()) {
				rankConfig.set(rank.getName(), null);

				continue;
			}

			rankConfig.set(rank.getName() + ".value", rank.getValue());

			rankConfig.set(rank.getName() + ".prefix", rank.getRawPrefix());
		}
	}

	public static void createRank(String name) {
		RANKS.put(name, new Rank(name, "", 0));
	}

	public static void removeRank(String name) {
		RANKS.remove(name);
	}

	public static Rank getRank(String name) {
		return RANKS.get(name);
	}

	public static Rank getDefaultRank() {
		return DEFAULT_RANK;
	}

	public static Collection<Rank> getRanks() {
		return RANKS.values();
	}

}

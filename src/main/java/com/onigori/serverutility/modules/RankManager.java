package com.onigori.serverutility.modules;

import com.onigori.api.confighelper.Config;
import com.onigori.api.confighelper.ConfigHelper;
import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.objects.Rank;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.ConfigurationSection;

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

				String prefix = ChatColor.translateAlternateColorCodes('&', section.getString(rankName + ".prefix", ""));

				final Rank rank = new Rank(rankName, prefix, value);

				RANKS.put(rankName, rank);

				if (rankName.equals("Default")) {
					DEFAULT_RANK = rank;
				}

			}

			return;
		}

		DEFAULT_RANK = new Rank("Default", "", 0);

		RANKS.put("Default", DEFAULT_RANK);

	}

	public static void stop() {
		for (Rank rank : RANKS.values()) {
			final Config rankConfig = ConfigHelper.getRankConfig();

			rankConfig.set(rank.getName() + ".value", rank.getValue());

			rankConfig.set(rank.getName() + ".prefix", rank.getPrefix());
		}
	}

	public static Rank getRank(String name) {
		return RANKS.get(name);
	}

	public static Rank getDefaultRank() {
		return DEFAULT_RANK;
	}

}

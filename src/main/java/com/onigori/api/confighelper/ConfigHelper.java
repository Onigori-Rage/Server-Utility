package com.onigori.api.confighelper;

import org.bukkit.plugin.java.JavaPlugin;

public class ConfigHelper {

	private static Config RANK;

	public static void init(JavaPlugin plugin) {
		RANK = new Config("rank.yml", "Rank", plugin);

		RANK.reloadConfig();
		RANK.saveConfig();
	}

	public static void stop() {

		RANK.saveConfig();
	}

	public static Config getRankConfig() {
		return RANK;
	}

}

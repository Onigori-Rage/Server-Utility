package com.onigori.api.confighelper;

import org.bukkit.plugin.java.JavaPlugin;

public class ConfigHelper {

	private static Config RANK;

	private static Config PLAYER;

	public static void init(JavaPlugin plugin) {
		RANK = new Config("rank.yml", "Rank", plugin);
		PLAYER = new Config("player.yml", "Player", plugin);

		RANK.reloadConfig();
		RANK.saveConfig();
		PLAYER.reloadConfig();
		PLAYER.saveConfig();
	}

	public static void stop() {
		PLAYER.saveConfig();
		RANK.saveConfig();
	}

	public static Config getRankConfig() {
		return RANK;
	}

	public static Config getPlayerConfig() {
		return PLAYER;
	}

}

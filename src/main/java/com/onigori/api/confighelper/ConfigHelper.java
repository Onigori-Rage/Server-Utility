package com.onigori.api.confighelper;

import org.bukkit.plugin.java.JavaPlugin;

public class ConfigHelper {

	private static Config RANK;

	private static Config SERVER;

	private static Config PLAYER;

	public static void init(JavaPlugin plugin) {
		SERVER = new Config("server.yml", "Server", plugin);
		RANK = new Config("rank.yml", "Rank", plugin);
		PLAYER = new Config("player.yml", "Player", plugin);

		SERVER.reloadConfig();
		SERVER.saveConfig();
		RANK.reloadConfig();
		RANK.saveConfig();
		PLAYER.reloadConfig();
		PLAYER.saveConfig();
	}

	public static void stop() {
		PLAYER.saveConfig();
		RANK.saveConfig();
		SERVER.saveConfig();
	}

	public static Config getServerConfig() {
		return SERVER;
	}

	public static Config getRankConfig() {
		return RANK;
	}

	public static Config getPlayerConfig() {
		return PLAYER;
	}

}

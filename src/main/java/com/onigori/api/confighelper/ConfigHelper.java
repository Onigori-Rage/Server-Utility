package com.onigori.api.confighelper;

import org.bukkit.plugin.java.JavaPlugin;

public class ConfigHelper {

	private static Config a;

	public static void init(JavaPlugin plugin) {
		a = new Config("test.yml", "Test", plugin);

		a.reloadConfig();
		a.saveConfig();
	}

	public static void stop() {

		a.saveConfig();
	}

	public static Config getConfig() {
		return a;
	}

}

package com.onigori.serverutility;

import com.onigori.serverutility.modules.SUtilLogger;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class SUtilMain {

	private static JavaPlugin plugin;

	private static CommandSender console;

	public static void init(JavaPlugin instance) {
		plugin = instance;
		console = Bukkit.getConsoleSender();

		SUtilLogger.printLog(Symbols.HELLO_MESSAGE);


	}

	public static void stop() {

	}

	public static JavaPlugin getInstance() {
		return plugin;
	}

	public static CommandSender getConsole() {
		return console;
	}

}

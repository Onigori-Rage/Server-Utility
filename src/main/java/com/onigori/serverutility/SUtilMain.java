package com.onigori.serverutility;

import com.onigori.serverutility.commands.CommandHandler;
import com.onigori.serverutility.modules.SUtilLogger;
import com.onigori.serverutility.modules.players.PlayerFactory;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class SUtilMain {

	private static JavaPlugin plugin;

	private static CommandSender console;

	private static CommandHandler commandHandler;

	private static PlayerFactory playerFactory;

	public static void onEnable(JavaPlugin instance) {
		plugin = instance;
		console = Bukkit.getConsoleSender();

		commandHandler = new CommandHandler();

		SUtilLogger.printLog(Symbols.HELLO_MESSAGE);

		playerFactory = new PlayerFactory();

	}

	public static void onDisable() {

	}

	public static JavaPlugin getInstance() {
		return plugin;
	}

	public static CommandSender getConsole() {
		return console;
	}

	public static PlayerFactory getPlayerFactory() {
		return playerFactory;
	}

	public static CommandHandler getCommandHandler() {
		return commandHandler;
	}

}

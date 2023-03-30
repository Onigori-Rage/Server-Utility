package com.onigori.serverutility;

import com.onigori.api.guihelper.GUIHelper;
import com.onigori.serverutility.commands.CommandHandler;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.listeners.LoginHandler;
import com.onigori.serverutility.modules.LocalizedMessage;
import com.onigori.serverutility.modules.players.PlayerFactory;
import com.onigori.serverutility.objects.Console;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class SUtilMain {

	private static JavaPlugin plugin;

	private static CommandSender console;

	private static CommandHandler commandHandler;

	private static Sender consoleSender;

	private static PlayerFactory playerFactory;

	public static void onEnable(JavaPlugin instance) {
		plugin = instance;

		LocalizedMessage.init();

		console = Bukkit.getConsoleSender();
		consoleSender = new Console();

		playerFactory = new PlayerFactory();
		/*
		Load api.
		 */
		GUIHelper.init(plugin);

		commandHandler = new CommandHandler();
		commandHandler.init();

		consoleSender.sendMessage("welcome", true);

		Bukkit.getPluginManager().registerEvents(new LoginHandler(), plugin);

	}

	public static void onDisable() {

	}

	public static JavaPlugin getInstance() {
		return plugin;
	}

	@Deprecated
	public static CommandSender getConsole() {
		return console;
	}

	public static Sender getSender() {
		return consoleSender;
	}

	public static PlayerFactory getPlayerFactory() {
		return playerFactory;
	}

	public static CommandHandler getCommandHandler() {
		return commandHandler;
	}

}

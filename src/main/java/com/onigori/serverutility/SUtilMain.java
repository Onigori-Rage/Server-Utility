package com.onigori.serverutility;

import com.onigori.api.confighelper.ConfigHelper;
import com.onigori.api.guihelper.GUIHelper;
import com.onigori.serverutility.commands.CommandHandler;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.listeners.ChatListener;
import com.onigori.serverutility.listeners.JailListener;
import com.onigori.serverutility.listeners.LoginListener;
import com.onigori.serverutility.listeners.QuitListener;
import com.onigori.serverutility.modules.LocalizedMessage;
import com.onigori.serverutility.modules.RankManager;
import com.onigori.serverutility.modules.players.PlayerFactory;
import com.onigori.serverutility.objects.Console;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashSet;

public class SUtilMain {

	private static JavaPlugin plugin;

	private static CommandSender console;

	private static CommandHandler commandHandler;

	private static Sender consoleSender;

	private static PlayerFactory playerFactory;

	private static RankManager rankManager;

	private static Location jailFallback;

	private static final HashSet<String> pluginsList = new HashSet<>();

	public static void onEnable(JavaPlugin instance) {
		plugin = instance;

		LocalizedMessage.init();

		ConfigHelper.init(plugin);

		rankManager = new RankManager();
		rankManager.init();

		console = Bukkit.getConsoleSender();
		consoleSender = new Console();

		playerFactory = new PlayerFactory();
		playerFactory.init();
		/*
		Load api.
		 */
		GUIHelper.init(plugin);

		commandHandler = new CommandHandler();
		commandHandler.init();

		consoleSender.sendMessage("welcome", true, Symbols.AUTHOR, Symbols.DISCORD, Symbols.VERSION);

		registerListeners();

	}

	public static void onDisable() {

		playerFactory.stop();

		rankManager.stop();

		ConfigHelper.stop();

		/*
		TODO Save config システムなどを追加する
		 */

	}

	public static void enableAddonPlugin(JavaPlugin plugin) {
		pluginsList.add(plugin.getName());

		consoleSender.sendTranslated("We found out addon, " + plugin.getName(), true);
	}

	public static JavaPlugin getInstance() {
		return plugin;
	}

	@Deprecated
	public static CommandSender getConsole() {
		return console;
	}

	private static void registerListeners() {
		Bukkit.getPluginManager().registerEvents(new LoginListener(), plugin);

		Bukkit.getPluginManager().registerEvents(new ChatListener(), plugin);

		Bukkit.getPluginManager().registerEvents(new QuitListener(), plugin);

		Bukkit.getPluginManager().registerEvents(new JailListener(), plugin);
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

	public static Location getJailFallback() {
		return jailFallback;
	}

	public static RankManager getRankManager() {
		return rankManager;
	}

}

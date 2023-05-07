package com.onigori.serverutility;

import com.onigori.api.confighelper.ConfigHelper;
import com.onigori.api.guihelper.GUIHelper;
import com.onigori.serverutility.apis.SUtilAddon;
import com.onigori.serverutility.commands.CommandHandler;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.listeners.ChatListener;
import com.onigori.serverutility.listeners.JailListener;
import com.onigori.serverutility.listeners.LoginListener;
import com.onigori.serverutility.listeners.QuitListener;
import com.onigori.serverutility.utils.players.RankManager;
import com.onigori.serverutility.utils.players.PlayerFactory;
import com.onigori.serverutility.objects.Console;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import sun.misc.Unsafe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Locale;

public class SUtilMain {

	private static JavaPlugin plugin;

	private static CommandSender console;

	private static CommandHandler commandHandler;

	private static Sender consoleSender;

	private static PlayerFactory playerFactory;

	private static RankManager rankManager;

	private static Locale locale;

	private static Location jailLocation;

	private static final LinkedHashMap<Integer, SUtilAddon> pluginsList = new LinkedHashMap<>();

	public static void onEnable(JavaPlugin instance) {
		plugin = instance;

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

	public static void enableAddonPlugin(SUtilAddon plugin) {
		pluginsList.put(plugin.getRegistrySerial(), plugin);

		consoleSender.sendMessage("addon-enable-message", true, plugin.getName(), plugin.getName(), plugin.getVersion(), plugin.getRegistrySerial());
	}

	public static SUtilAddon getAddon(final int registrySerial) {
		return pluginsList.get(registrySerial);
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

	public static RankManager getRankManager() {
		return rankManager;
	}

	@Deprecated
	public static void interruptSystemPrefix(String fixedPrefix) {

		try {
			final Constructor<Unsafe> unsafeConstructor = Unsafe.class.getDeclaredConstructor();

			unsafeConstructor.setAccessible(true);

			final Unsafe unsafe = unsafeConstructor.newInstance();

			final Field prefix = Symbols.class.getDeclaredField("PREFIX");
			unsafe.putObject(unsafe.staticFieldBase(prefix), unsafe.staticFieldOffset(prefix), fixedPrefix);

		}

		catch (Exception exception) {
			exception.printStackTrace();
		}

	}

	public static Locale getLocale() {
		return locale;
	}

	public static void setLocale(Locale locale) {
		SUtilMain.locale = locale;
	}

	public static Location getJailLocation() {
		return jailLocation;
	}

	public static void setJailLocation(Location location) {
		jailLocation = location;
	}

}

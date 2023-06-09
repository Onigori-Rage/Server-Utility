package com.onigori.api.guihelper;

import com.onigori.api.guihelper.components.InventoryHandler;
import com.onigori.api.guihelper.components.OnigoriScreen;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class GUIHelper {

	/*
	This api helps you create spigot gui.
	Async.
	 */

	private static JavaPlugin plugin;

	public static void init(JavaPlugin plugin) {
		Bukkit.getPluginManager().registerEvents(new InventoryHandler(), plugin);
		GUIHelper.plugin = plugin;
	}

	public static JavaPlugin getPlugin() {
		return plugin;
	}

	public static void openInventory(OnigoriScreen screen, Player player) {
		Bukkit.getScheduler().runTask(plugin, () ->
				player.openInventory(screen.getInventory())
		);

	}

	public static void closeInventory(Player player) {
		Bukkit.getScheduler().runTask(plugin, player::closeInventory);
	}

}

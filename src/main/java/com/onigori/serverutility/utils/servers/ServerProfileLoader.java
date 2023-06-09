package com.onigori.serverutility.utils.servers;

import com.onigori.api.confighelper.Config;
import com.onigori.api.confighelper.ConfigHelper;
import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.Symbols;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.Locale;

public class ServerProfileLoader {

	public static void init() {
		final Config serverConfig = ConfigHelper.getServerConfig();

		final Locale locale = ((String) serverConfig.get("locale", Symbols.DEFAULT_LOCALE.getDisplayName(Locale.ENGLISH))).equalsIgnoreCase("Japanese") ? Locale.JAPANESE : Locale.ENGLISH;

		String worldName = (String) serverConfig.get("jailLocation.world", null);
		Double x = (Double) serverConfig.get("jailLocation.x", null);
		Double y = (Double) serverConfig.get("jailLocation.y", null);
		Double z = (Double) serverConfig.get("jailLocation.z", null);

		Location jailLocation = null;

		if (worldName != null && x != null && y != null && z != null) {
			jailLocation = new Location(Bukkit.getWorld(worldName), x, y, z);
		}

		SUtilMain.getSender().setLocale(locale);

		SUtilMain.setJailLocation(jailLocation);

	}

	public static void stop() {
		final Config serverConfig = ConfigHelper.getServerConfig();

		final Location location = SUtilMain.getJailLocation();

		if (location != null) {

			serverConfig.set("jailLocation.world", location.getWorld().getName());

			serverConfig.set("jailLocation.x", location.getX());
			serverConfig.set("jailLocation.y", location.getY());
			serverConfig.set("jailLocation.z", location.getZ());

		}

		serverConfig.set("locale", SUtilMain.getSender().getLocale().getDisplayName(Locale.ENGLISH));

	}

}

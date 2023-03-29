package com.onigori.serverutility.bootstrap;

import com.onigori.serverutility.SUtilMain;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class PluginBootstrap extends JavaPlugin {

	@Override
	public void onEnable() {
		SUtilMain.init(this);
	}

	@Override
	public void onDisable() {

	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments) {
		/*
		TODO Below add code.
		 */

		return true;
	}

}

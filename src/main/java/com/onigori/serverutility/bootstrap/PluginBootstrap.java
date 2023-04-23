package com.onigori.serverutility.bootstrap;

import com.onigori.serverutility.SUtilMain;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class PluginBootstrap extends JavaPlugin {

	@Override
	public void onEnable() {
		SUtilMain.onEnable(this);
	}

	@Override
	public void onDisable() {
		SUtilMain.onDisable();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments) {

		SUtilMain.getCommandHandler().dispatchCommand(sender, arguments, command.getName());

		return true;
	}

}

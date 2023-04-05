package com.onigori.serverutility.bootstrap;

import com.onigori.serverutility.SUtilMain;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import javax.sound.midi.SysexMessage;

public class PluginBootstrap extends JavaPlugin {

	@Override
	public void onEnable() {
		SUtilMain.onEnable(this);
	}

	@Override
	public void onDisable() {

	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] arguments) {
		/*
		Fixed command implements logic.
		 */
		long a = System.nanoTime();
		Bukkit.getScheduler().runTaskAsynchronously(this,
				() -> SUtilMain.getCommandHandler().dispatchCommand(sender, arguments, command.getName())
		);

		long b = System.nanoTime();

		System.out.println(b-a + "ns SUtil EXECUTING");
		return true;
	}

}

package com.onigori.serverutility.bootstrap;

import com.onigori.serverutility.SUtilMain;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Random;

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

	@Override
	public ChunkGenerator getDefaultWorldGenerator(String name, String id) {
		return new ChunkGenerator() {

			@SuppressWarnings("deprecation")
			@Override
			public byte[] generate(World world, Random random, int x, int z) {
				return new byte[32768];
			}

		};
	}

}

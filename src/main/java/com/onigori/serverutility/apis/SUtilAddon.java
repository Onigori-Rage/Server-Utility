package com.onigori.serverutility.apis;

import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.Symbols;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public abstract class SUtilAddon extends JavaPlugin {

	@Override
	public final void onEnable() {

		SUtilMain.enableAddonPlugin(this);

		init();

	}

	public abstract void init();

	@Override
	public final void onDisable() {
		stop();
	}

	public abstract void stop();

	public abstract String getVersion();

	public abstract int getRegistrySerial();

	@Override
	public final boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {

		SUtilMain.getCommandHandler().dispatchCommand(sender, args, command.getName());

		return true;
	}

	public final void registerCommand(com.onigori.serverutility.commands.Command command) {
		SUtilMain.getCommandHandler().addCommand(command);
	}

	public abstract ResourceBundle getJapaneseBundle();

	public abstract ResourceBundle getEnglishBundle();

	public final String getLocalizedMessage(String key, Locale locale, Object... args) {
		final String message = (locale == Locale.JAPANESE ? getJapaneseBundle().getString(key) : getEnglishBundle().getString(key));

		return (args.length == 0 ? message : MessageFormat.format(message, args));
	}

}

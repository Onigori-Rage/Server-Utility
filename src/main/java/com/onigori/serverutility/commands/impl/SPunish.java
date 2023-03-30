package com.onigori.serverutility.commands.impl;

import com.onigori.serverutility.commands.AbstractCommand;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.modules.LocalizedMessage;
import com.onigori.serverutility.objects.Permission;
import org.bukkit.command.CommandSender;

import java.util.Locale;

public class SPunish extends AbstractCommand {

	public SPunish() {
		super("spunish", "usageKey", "descriptionKey", Permission.HIGHEST);
	}

	@Override
	public void execute(Sender sender, String[] args) {
		LocalizedMessage.setLocale(args[0].equalsIgnoreCase("English") ? Locale.ENGLISH : Locale.JAPANESE);
	}

}

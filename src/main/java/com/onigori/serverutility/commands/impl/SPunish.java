package com.onigori.serverutility.commands.impl;

import com.onigori.serverutility.commands.AbstractCommand;
import com.onigori.serverutility.objects.Permission;
import org.bukkit.command.CommandSender;

public class SPunish extends AbstractCommand {

	public SPunish() {
		super("spunish", "usageKey", "descriptionKey", Permission.HIGHEST);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {

	}

}

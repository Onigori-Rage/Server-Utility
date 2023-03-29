package com.onigori.serverutility.commands.impl;

import com.onigori.serverutility.commands.AbstractCommand;
import com.onigori.serverutility.objects.Permission;
import org.bukkit.command.CommandSender;

public class DefaultCommand extends AbstractCommand {

	public DefaultCommand() {
		super(null, null, null, Permission.NORMAL);
	}

	@Override
	public void execute(CommandSender sender, String[] args) {

	}

}

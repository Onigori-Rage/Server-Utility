package com.onigori.serverutility.commands.impl;

import com.onigori.serverutility.commands.AbstractCommand;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.objects.Permission;
import org.bukkit.command.CommandSender;

public class Default extends AbstractCommand {

	public Default() {
		super(null, null, null, Permission.NORMAL);
	}

	@Override
	public void execute(Sender sender, String[] args) {
		sender.sendTranslated("Undefined", true);
	}

}

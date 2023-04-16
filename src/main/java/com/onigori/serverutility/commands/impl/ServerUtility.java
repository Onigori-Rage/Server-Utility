package com.onigori.serverutility.commands.impl;

import com.onigori.serverutility.commands.Command;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.commands.SubCommand;
import com.onigori.serverutility.objects.Permission;

public class ServerUtility extends Command {

	public ServerUtility() {
		super("server-utility", "usageKey", "descriptionKey", Permission.HIGHEST);
	}

	@Override
	public void execute(Sender sender, String[] args) {
		sender.sendMessage("command-server-utility-usage", true);
		if (args.length >= 1) {

		}

	}

}

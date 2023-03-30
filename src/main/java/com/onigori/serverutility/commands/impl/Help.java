package com.onigori.serverutility.commands.impl;

import com.onigori.serverutility.commands.Command;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.objects.Permission;

public class Help extends Command {

	public Help() {
		super("shelp", "command-shelp-mainhelp", "command-shelp-usage", Permission.NORMAL);
	}

	@Override
	public void execute(Sender sender, String[] args) {
		if (args.length >= 1) {
			return;
		}

		sender.sendMessage(this.getUsageKey(), true);
	}

}

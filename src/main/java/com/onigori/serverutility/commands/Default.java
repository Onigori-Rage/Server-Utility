package com.onigori.serverutility.commands;

import com.onigori.serverutility.commands.Command;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.objects.Permission;

public class Default extends Command {

	public Default() {
		super(null, null, null, Permission.NORMAL);
	}

	@Override
	public void execute(Sender sender, String[] args) {
		sender.sendMessage("command-undefined-error", true);
	}

}

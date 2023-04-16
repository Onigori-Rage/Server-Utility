package com.onigori.serverutility.commands;

import com.onigori.serverutility.commands.Command;
import com.onigori.serverutility.commands.Sender;

public class Default extends Command {

	public Default() {
		super();
	}

	@Override
	public void execute(Sender sender, String[] args) {
		sender.sendMessage("command-undefined-error", true);
	}

}

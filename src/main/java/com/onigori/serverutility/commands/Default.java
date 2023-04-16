package com.onigori.serverutility.commands;

public class Default extends Command {

	public Default() {
		super();
	}

	@Override
	public void execute(Sender sender, String[] args) {
		sender.sendMessage("command-undefined-error", true);
	}

}

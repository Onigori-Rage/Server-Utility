package com.onigori.serverutility.commands.impl;

import com.onigori.serverutility.commands.Command;
import com.onigori.serverutility.commands.CommandHandler;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.commands.SubCommand;
import com.onigori.serverutility.commands.impl.help.Info;
import com.onigori.serverutility.commands.impl.help.List;
import com.onigori.serverutility.commands.impl.help.SetJail;

import java.util.HashMap;

public class Help extends Command {

	private final HashMap<String, SubCommand> subcommands = new HashMap<>();

	public Help() {
		super("help", "command-help-usage", "command-help-description", CommandHandler.HELP_VALUE);

		this.subcommands.put("info", new Info());
		this.subcommands.put("command", new com.onigori.serverutility.commands.impl.help.Command());
		this.subcommands.put("list", new List());
		this.subcommands.put("setjail", new SetJail());

	}

	@Override
	public void execute(Sender sender, String[] args) {
		if (args.length >= 1) {
			final SubCommand subcommand = this.subcommands.get(args[0].toLowerCase());

			if (subcommand != null) {
				subcommand.execute(sender, args, this);
				return;
			}

		}

		sender.sendMessage(this.getUsageKey(), true);
	}

}

package com.onigori.serverutility.commands.impl;

import com.onigori.serverutility.commands.Command;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.commands.SubCommand;
import com.onigori.serverutility.commands.impl.rank.Create;
import com.onigori.serverutility.commands.impl.rank.Info;
import com.onigori.serverutility.commands.impl.rank.Prefix;

import java.util.HashMap;

public class Rank extends Command {

	private final HashMap<String, SubCommand> subcommands = new HashMap<>();

	public Rank() {
		super("srank", "command-srank-usage", "command-srank-description");

		this.subcommands.put("info", new Info());

		this.subcommands.put("prefix", new Prefix());

		subcommands.put("create", new Create());
	}

	@Override
	public void execute(Sender sender, String[] args) {
		if (args.length >= 2) {
			SubCommand subcommand = this.subcommands.get(args[0].toLowerCase());

			if (subcommand != null) {
				subcommand.execute(sender, args, this);
				return;
			}

		}

		sender.sendMessage(this.getUsageKey(), true);
	}

}

package com.onigori.serverutility.commands.impl;

import com.onigori.serverutility.commands.Command;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.commands.SubCommand;
import com.onigori.serverutility.commands.impl.rank.*;

import java.util.HashMap;

public class Rank extends Command {

	private final HashMap<String, SubCommand> subcommands = new HashMap<>();

	public Rank() {
		super("rank", "command-rank-usage", "command-rank-description");

		this.subcommands.put("info", new Info());

		this.subcommands.put("prefix", new Prefix());

		subcommands.put("create", new Create());

		subcommands.put("list", new List());

		subcommands.put("remove", new Remove());

		subcommands.put("value", new Value());

		subcommands.put("player", new Player());
	}

	@Override
	public void execute(Sender sender, String[] args) {
		if (args.length >= 2 || (args.length == 1 && args[0].toLowerCase().equals("list"))) {
			final SubCommand subcommand = this.subcommands.get(args[0].toLowerCase());

			if (subcommand != null) {
				subcommand.execute(sender, args, this);
				return;
			}

		}

		sender.sendMessage(this.getUsageKey(), true);
	}

}

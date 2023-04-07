package com.onigori.serverutility.commands.impl;

import com.onigori.serverutility.commands.Command;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.commands.SubCommand;
import com.onigori.serverutility.commands.impl.punish.*;
import com.onigori.serverutility.objects.Permission;

import java.util.HashMap;

public class Punish extends Command {

	private final HashMap<String, SubCommand> subcommands = new HashMap<>();

	/*
	TODO Add mute and ban logic.
	 */
	public Punish() {
		super("spunish", "command-spunish-usage", "command-spunish-description", Permission.NORMAL);//Permission.HIGHEST);

		this.subcommands.put("panel", new Panel());

		this.subcommands.put("kick", new Kick());
		this.subcommands.put("warn", new Warn());

		this.subcommands.put("ban", new Ban());
		this.subcommands.put("tban", new TBan());

		this.subcommands.put("mute", null);
		this.subcommands.put("tmute", null);
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

package com.onigori.serverutility.commands.impl;

import com.onigori.api.guihelper.GUIHelper;
import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.commands.Command;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.commands.SubCommand;
import com.onigori.serverutility.commands.impl.punish.Panel;
import com.onigori.serverutility.objects.Permission;
import com.onigori.serverutility.players.SUtilPlayer;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Punish extends Command {

	private final HashMap<String, SubCommand> subcommands = new HashMap<>();

	public Punish() {
		super("spunish", "usageKey", "descriptionKey", Permission.NORMAL);//Permission.HIGHEST);
		this.subcommands.put("panel", new Panel());
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

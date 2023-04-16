package com.onigori.serverutility.commands.impl.rank;

import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.commands.Command;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.commands.SubCommand;
import com.onigori.serverutility.modules.RankManager;
import com.onigori.serverutility.objects.Rank;

public class Remove implements SubCommand {

	@Override
	public void execute(Sender sender, String[] args, Command instance) {
		final Rank rank = SUtilMain.getRankManager().getRank(args[1].toLowerCase());

		if (rank != null) {

			if (rank.getName().equals("default")) {

				sender.sendMessage("command-srank-remove-failed-default", true);

				return;
			}

			rank.remove();

			sender.sendMessage("command-srank-remove-success", true, rank.getName());

			return;
		}

		sender.sendMessage("command-srank-remove-failed", true);
	}

}

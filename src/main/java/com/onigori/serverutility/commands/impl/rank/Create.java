package com.onigori.serverutility.commands.impl.rank;

import com.onigori.serverutility.commands.Command;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.commands.SubCommand;
import com.onigori.serverutility.modules.RankManager;
import com.onigori.serverutility.objects.Rank;

public class Create implements SubCommand {

	@Override
	public void execute(Sender sender, String[] args, Command instance) {
		final Rank rank = RankManager.getRank(args[1].toLowerCase());

		if (rank == null) {

			RankManager.createRank(args[1].toLowerCase());

			sender.sendMessage("command-srank-create-success", true, args[1].toLowerCase());

			return;
		}

		sender.sendMessage("command-srank-create-failed", true);
	}

}

package com.onigori.serverutility.commands.impl.rank;

import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.commands.Command;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.commands.SubCommand;
import com.onigori.serverutility.modules.RankManager;
import com.onigori.serverutility.objects.Rank;

public class Info implements SubCommand {

	@Override
	public void execute(Sender sender, String[] args, Command instance) {
		final Rank rank = SUtilMain.getRankManager().getRank(args[1].toLowerCase());

		if (rank != null) {
			sender.sendMessage("command-srank-info-success", true, rank.getName(), rank.getPrefix(), String.valueOf(rank.getValue()));

			return;
		}

		sender.sendMessage("command-srank-info-failed", true);

	}

}

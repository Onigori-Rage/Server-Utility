package com.onigori.serverutility.commands.impl.rank;

import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.commands.Command;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.commands.SubCommand;
import com.onigori.serverutility.objects.Rank;
import com.onigori.serverutility.objects.players.SUtilPlayer;

public class Player implements SubCommand {

	@Override
	public void execute(Sender sender, String[] args, Command instance) {

		if (args.length >= 3) {
			final SUtilPlayer player = SUtilMain.getPlayerFactory().fetch(args[1]);

			final Rank rank = SUtilMain.getRankManager().getRank(args[2].toLowerCase());

			if (rank != null) {
				player.setRank(rank);

				sender.sendTranslated("you have changed player's rank.", true);

				return;
			}
		}

		sender.sendMessage(instance.getUsageKey(), true);
	}

}

package com.onigori.serverutility.commands.impl.rank;

import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.commands.Command;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.commands.SubCommand;
import com.onigori.serverutility.objects.Rank;

public class Value implements SubCommand {

	@Override
	public void execute(Sender sender, String[] args, Command instance) {
		if (args.length >= 3) {
			final Rank rank = SUtilMain.getRankManager().getRank(args[1].toLowerCase());

			if (rank != null) {

				try {
					rank.setValue(Integer.parseInt(args[2]));

					sender.sendMessage("command-srank-value-success", true);

					return;
				}

				catch (Exception exception) {

				}
			}

		}

		sender.sendMessage(instance.getUsageKey(), true);
	}

}

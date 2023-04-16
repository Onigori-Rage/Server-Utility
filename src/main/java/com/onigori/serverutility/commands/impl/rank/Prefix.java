package com.onigori.serverutility.commands.impl.rank;

import com.onigori.serverutility.commands.Command;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.commands.SubCommand;
import com.onigori.serverutility.modules.ArgumentManager;
import com.onigori.serverutility.modules.RankManager;
import com.onigori.serverutility.objects.Rank;

public class Prefix implements SubCommand {

	@Override
	public void execute(Sender sender, String[] args, Command instance) {
		if (args.length >= 3) {
			final Rank rank = RankManager.getRank(args[1].toLowerCase());

			if (rank != null) {

				if (args[2].equalsIgnoreCase("clear")) {

					rank.setPrefix("");

					sender.sendMessage("command-srank-prefix-success-clear", true, rank.getPrefix());

					return;
				}

				rank.setPrefix(ArgumentManager.getArgumentsByArray(args, 2, " ") + " ");

				final String prefix = rank.getPrefix();

				sender.sendMessage("command-srank-prefix-success", true, prefix.substring(0, prefix.length() - 1));

				return;
			}

		}

		sender.sendMessage(instance.getUsageKey(), true);


	}

}

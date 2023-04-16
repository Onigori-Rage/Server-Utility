package com.onigori.serverutility.commands.impl.rank;

import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.commands.Command;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.commands.SubCommand;
import com.onigori.serverutility.objects.Rank;

public class List implements SubCommand {

	@Override
	public void execute(Sender sender, String[] args, Command instance) {
		StringBuilder stringBuilder = new StringBuilder();

		for (Rank rank : SUtilMain.getRankManager().getRanks()) {
			if (!rank.isToBeRemoved()) {
				stringBuilder.append(rank.getName() + ", ");
			}
		}

		stringBuilder.setLength(stringBuilder.length() - 2);

		String ranksList = stringBuilder.toString();

		sender.sendMessage("command-srank-list-success", true, ranksList);
	}

}

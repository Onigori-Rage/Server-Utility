package com.onigori.serverutility.commands.impl;

import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.commands.Command;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.objects.players.SUtilPlayer;

public class UserInfo extends Command {

	public UserInfo() {
		super("userinfo", "command-userinfo-usage", "descriptionKey");
	}

	@Override
	public void execute(Sender sender, String[] args) {
		if (args.length >= 1) {
			final SUtilPlayer user = SUtilMain.getPlayerFactory().fetch(args[0]);

			sender.sendMessage("command-userinfo-success", true, user.getName(), user.getUUID(), user.getRank().getName(), user.getLocale().getDisplayName(sender.getLocale()), user.isBanned(), user.isMuted());

			return;
		}

		sender.sendMessage(getUsageKey(), true);
	}

}

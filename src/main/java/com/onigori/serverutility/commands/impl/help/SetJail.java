package com.onigori.serverutility.commands.impl.help;

import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.commands.Command;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.commands.SubCommand;
import com.onigori.serverutility.objects.players.SUtilPlayer;

public class SetJail implements SubCommand {

	@Override
	public void execute(Sender sender, String[] args, Command instance) {
		if (sender.isPlayer()) {
			final SUtilPlayer player = (SUtilPlayer) sender;

			SUtilMain.setJailFallback(player.getLocation());

			player.sendTranslated("Set the jail location.", true);
			return;
		}

		sender.sendMessage("command-executor-error", true);
	}

}

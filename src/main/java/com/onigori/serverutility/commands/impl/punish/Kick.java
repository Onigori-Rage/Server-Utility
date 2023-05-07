package com.onigori.serverutility.commands.impl.punish;

import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.Symbols;
import com.onigori.serverutility.commands.Command;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.commands.SubCommand;
import com.onigori.serverutility.utils.commons.ArgumentManager;
import com.onigori.serverutility.objects.players.SUtilPlayer;

public class Kick implements SubCommand {

	@Override
	public void execute(Sender sender, String[] args, Command instance) {
		SUtilPlayer target = SUtilMain.getPlayerFactory().fetch(args[1]);

		String reason = args.length >= 3 ? ArgumentManager.getArgumentsByArray(args, 2, " ") : Symbols.DEFAULT_REASON;

		new com.onigori.serverutility.objects.punishments.impl.Kick(reason, sender, target).queue();
	}

}

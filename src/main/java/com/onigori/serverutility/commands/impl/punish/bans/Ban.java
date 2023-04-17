package com.onigori.serverutility.commands.impl.punish.bans;

import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.Symbols;
import com.onigori.serverutility.commands.Command;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.commands.SubCommand;
import com.onigori.serverutility.modules.ArgumentManager;
import com.onigori.serverutility.objects.players.SUtilPlayer;

public class Ban implements SubCommand {

	@Override
	public void execute(Sender sender, String[] args, Command instance) {

		final SUtilPlayer target = SUtilMain.getPlayerFactory().fetch(args[1]);

		String reason = args.length >= 3 ? ArgumentManager.getArgumentsByArray(args, 2, " ") : Symbols.DEFAULT_REASON;

		new com.onigori.serverutility.objects.punishments.Ban(reason, sender, target).queue();

	}

}

package com.onigori.serverutility.commands.impl.punish.mutes;

import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.Symbols;
import com.onigori.serverutility.commands.Command;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.commands.SubCommand;
import com.onigori.serverutility.modules.ArgumentManager;
import com.onigori.serverutility.objects.players.SUtilPlayer;
import com.onigori.serverutility.objects.punishments.Mute;

import java.util.Calendar;

public class TMute implements SubCommand {

	@Override
	public void execute(Sender sender, String[] args, Command instance) {

		if (args.length < 3) {
			sender.sendMessage(instance.getUsageKey(), true);

			return;
		}

		try {
			final int days = Integer.parseInt(args[2]);

			final Calendar calendar = Calendar.getInstance();

			calendar.add(Calendar.DAY_OF_MONTH, days);

			SUtilPlayer target = SUtilMain.getPlayerFactory().fetch(args[1]);

			String reason = args.length >= 4 ? ArgumentManager.getArgumentsByArray(args, 3, " ") : Symbols.DEFAULT_REASON;

			new Mute(reason, sender, target, calendar.getTime()).queue();
		}

		catch (Exception exception) {
			sender.sendMessage(instance.getUsageKey(), true);
		}

	}
}

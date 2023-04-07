package com.onigori.serverutility.commands.impl;

import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.commands.Command;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.objects.Permission;
import com.onigori.serverutility.players.SUtilPlayer;

public class Test extends Command {

	public Test() {
		super("test", null, null, Permission.NORMAL);
	}

	@Override
	public void execute(Sender sender, String[] args) {
		if (args.length >= 2) {
			SUtilPlayer target = SUtilMain.getPlayerFactory().fetch(args[0]);

			if (args[1].equalsIgnoreCase("staff")) {
				target.setPermission(Permission.HIGHEST);
			}

			else if (args[1].equalsIgnoreCase("normal")) {
				target.setPermission(Permission.NORMAL);
			}

			else {
				sender.sendTranslated("/test <player> <perm>", true);
			}

		}
		else {
			sender.sendTranslated("/test <player> <perm>", true);
		}
	}
}

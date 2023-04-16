package com.onigori.serverutility.commands.impl;

import com.onigori.serverutility.commands.Command;
import com.onigori.serverutility.commands.Sender;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

import java.util.UUID;

public class Test extends Command {

	public Test() {
		super("test", null, null);
	}

	@Override
	public void execute(Sender sender, String[] args) {

		OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(UUID.fromString(args[0]));

		sender.sendTranslated(offlinePlayer.getName(), true);

		/*if (args.length >= 1) {
			int a = Integer.parseInt(args[0]);

			SUtilMain.getRankManager().getDefaultRank().setValue(a);

		}

		 */

		/*if (args.length >= 2) {
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

		 */
	}
}

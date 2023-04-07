package com.onigori.serverutility.commands.impl;

import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.commands.Command;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.modules.SearchParser;
import com.onigori.serverutility.objects.Permission;
import com.onigori.serverutility.players.SUtilPlayer;

public class Search extends Command {

	public Search() {
		super("ssearch", "usageKey", "descriptionKey", Permission.NORMAL);
	}

	@Override
	public void execute(Sender sender, String[] args) {
		if (args.length >= 1) {
			for (SUtilPlayer player : SUtilMain.getPlayerFactory().query(SearchParser.parse(args))) {
				sender.sendTranslated("We have found: " + player.getName(), true);
			}
		}

		else {
			sender.sendTranslated("/search <filters...>", true);
		}
	}

}
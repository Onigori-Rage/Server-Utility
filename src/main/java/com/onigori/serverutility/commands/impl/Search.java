package com.onigori.serverutility.commands.impl;

import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.commands.Command;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.modules.ArgumentManager;
import com.onigori.serverutility.modules.SearchParser;
import com.onigori.serverutility.objects.players.SUtilPlayer;
import io.netty.util.internal.ConcurrentSet;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.PropertyResourceBundle;
import java.util.stream.Collectors;

public class Search extends Command {

	public Search() {
		super("search", "usageKey", "descriptionKey");
	}

	@Override
	public void execute(Sender sender, String[] args) {
		if (args.length >= 1) {
			final Collection<SUtilPlayer> result = SUtilMain.getPlayerFactory().query(SearchParser.parse(args));

			if (!result.isEmpty()) {
				sender.sendTranslated(ArgumentManager.getArgumentsByObjects(result.toArray(), 0, ", "), true);
			}

			else {
				sender.sendTranslated("§cSorry, but cannot find the player.", true);
			}

		}

		else {
			sender.sendTranslated("/search <filters...>", true);
		}
	}

}

package com.onigori.serverutility.commands.impl;

import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.commands.Command;
import com.onigori.serverutility.commands.CommandHandler;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.modules.ArgumentManager;
import com.onigori.serverutility.modules.SearchParser;
import com.onigori.serverutility.objects.players.SUtilPlayer;
import io.netty.util.internal.ConcurrentSet;

import java.util.*;
import java.util.stream.Collectors;

public class Search extends Command {

	public Search() {
		super("search", "command-search-usage", "descriptionKey", CommandHandler.SEARCH_VALUE);
	}

	@Override
	public void execute(Sender sender, String[] args) {
		if (args.length >= 1) {
			final HashMap<SearchParser.Option, String> options = SearchParser.parse(args);

			if (options.isEmpty()) {
				sender.sendMessage(getUsageKey(), true);

				return;
			}

			final Collection<SUtilPlayer> result = SUtilMain.getPlayerFactory().query(options);

			if (!result.isEmpty()) {

				sender.sendMessageIncludingBlank("command-search-success", true, ArgumentManager.getArgumentsByObjects(result.toArray(), 0, ", "));

			}

			else {
				sender.sendMessageIncludingBlank("command-search-failed", true);
			}

			return;

		}

		sender.sendMessage(getUsageKey(), true);

	}

}

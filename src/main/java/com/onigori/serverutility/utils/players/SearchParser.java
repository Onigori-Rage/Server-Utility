package com.onigori.serverutility.utils.players;

import com.onigori.serverutility.objects.players.SUtilPlayer;

import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

public class SearchParser {

	public static HashMap<Option, String> parse(String[] filters) {

		final HashMap<Option, String> filtering = new HashMap<>();

		for (String option : filters) {
			String[] reformatted = option.split(":");

			if (reformatted.length < 2) {
				continue;
			}

			if (reformatted[0].equalsIgnoreCase("name")) {
				filtering.put(new NameFilter(), reformatted[1]);
			}

			if (reformatted[0].equalsIgnoreCase("rank")) {
				filtering.put(new RankFilter(), reformatted[1]);
			}

		}

		return filtering;

	}

	public abstract static class Option {

		public abstract Collection<SUtilPlayer> handle(Collection<SUtilPlayer> stream, String arg);

	}

	public static class NameFilter extends Option {

		@Override
		public Collection<SUtilPlayer> handle(Collection<SUtilPlayer> collection, String arg) {
			return collection.stream().filter(player -> player.getName().toLowerCase().startsWith(arg.toLowerCase())).collect(Collectors.toSet());
		}

	}

	public static class RankFilter extends Option {

		@Override
		public Collection<SUtilPlayer> handle(Collection<SUtilPlayer> collection, String arg) {
			return collection.stream().filter(player -> player.getRank().getName().equalsIgnoreCase(arg)).collect(Collectors.toSet());
		}

	}

}

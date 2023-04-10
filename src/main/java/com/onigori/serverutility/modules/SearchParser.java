package com.onigori.serverutility.modules;

import com.onigori.serverutility.players.SUtilPlayer;

import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchParser {

	public static HashMap<Option, String> parse(String[] filters) {
		final HashMap<Option, String> filtering = new HashMap<>();

		for (String option : filters) {
			String[] reformatted = option.split(":");

			if (reformatted[0].equalsIgnoreCase("name")) {
				filtering.put(new NameFilter(), reformatted[1]);
			}

			if (reformatted[0].equalsIgnoreCase("permission")) {
				filtering.put(new PermissionFilter(), reformatted[1]);
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

	public static class PermissionFilter extends Option {

		@Override
		public Collection<SUtilPlayer> handle(Collection<SUtilPlayer> collection, String arg) {
			return collection.stream().filter(player -> player.getPermission().name().equalsIgnoreCase(arg)).collect(Collectors.toSet());
		}

	}

}

package com.onigori.serverutility.modules;

public class ArgumentManager {

	public static String getArgumentsByArray(String[] args, int startIndex, String suffix) {
		final StringBuilder stringBuilder = new StringBuilder();

		for (int index = startIndex; index <= (args.length - 1); index = index + 1) {
			stringBuilder.append(args[index] + suffix);
		}

		stringBuilder.setLength(stringBuilder.length() - suffix.length());
		return stringBuilder.toString();
	}

}

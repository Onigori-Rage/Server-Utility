package com.onigori.serverutility.utils.commons;

public class ArgumentManager {

	public static String getArgumentsByArray(String[] args, int startIndex, String suffix) {
		final StringBuilder stringBuilder = new StringBuilder();

		for (int index = startIndex; index <= (args.length - 1); index = index + 1) {
			stringBuilder.append(args[index]).append(suffix);
		}

		stringBuilder.setLength(stringBuilder.length() - suffix.length());
		return stringBuilder.toString();
	}

	public static String getArgumentsByObjects(Object[] args, int startIndex, String suffix) {
		final StringBuilder stringBuilder = new StringBuilder();

		for (int index = startIndex; index <= (args.length - 1); index = index + 1) {
			stringBuilder.append(args[index].toString()).append(suffix);
		}

		stringBuilder.setLength(stringBuilder.length() - suffix.length());
		return stringBuilder.toString();
	}

}

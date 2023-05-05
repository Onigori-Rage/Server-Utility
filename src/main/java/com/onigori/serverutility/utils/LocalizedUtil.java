package com.onigori.serverutility.utils;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizedUtil {

	private static ResourceBundle japanese;

	private static ResourceBundle english;

	public static void init() {
		japanese = ResourceBundle.getBundle("message", Locale.JAPANESE);
		english = ResourceBundle.getBundle("message", Locale.ENGLISH);
	}

	public static void stop() {

	}

	/*
	二言語だけだから、このようなコードでも可能。
	Reformat するべき。
	 */
	public static String getLocalizedMessage(String key, Locale locale, Object... args) {
		final String message = (locale == Locale.JAPANESE ? japanese.getString(key) : english.getString(key));

		return (args.length == 0 ? message : MessageFormat.format(message, args));
	}

}

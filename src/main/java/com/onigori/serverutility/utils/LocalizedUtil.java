package com.onigori.serverutility.utils;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizedUtil {

	private static final ResourceBundle japanese = ResourceBundle.getBundle("message", Locale.JAPANESE);

	private static final ResourceBundle english = ResourceBundle.getBundle("message", Locale.ENGLISH);

	public static String getLocalizedMessage(String key, Locale locale, Object... args) {
		return MessageFormat.format(getLocalizedMessage(key, locale), args);
	}

	public static String getLocalizedMessage(String key, Locale locale) {
		return locale == Locale.JAPANESE ? japanese.getString(key) : english.getString(key);
	}

}

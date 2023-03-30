package com.onigori.serverutility.modules;

import com.onigori.serverutility.objects.IInit;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocalizedMessage implements IInit {

	private static Locale locale = Locale.ENGLISH;

	private static ResourceBundle resourceBundle;

	@Override
	public void init() {
		try {
			resourceBundle = ResourceBundle.getBundle("message", locale);
		}
		catch (Exception exception) {
			resourceBundle = ResourceBundle.getBundle("message", Locale.ENGLISH);
		}
	}

	@Override
	public void stop() {

	}

	public static void setLocale(Locale locale) {
		LocalizedMessage.locale = locale;
	}

	public static String getLocalizedMessage(String key, String... args) {
		String message = resourceBundle.getString(key);
		return (args.length == 0 ? message : MessageFormat.format(message, args));
	}

}
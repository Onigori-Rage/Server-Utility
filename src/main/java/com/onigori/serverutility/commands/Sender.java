package com.onigori.serverutility.commands;

import com.onigori.serverutility.objects.Permission;

import java.util.Locale;

public interface Sender {

	void sendTranslated(String message, boolean prefix);

	void sendMessage(String key, boolean prefix, String... args);

	Permission getPermission();

	Locale getLocale();

	void setLocale(Locale locale);

}

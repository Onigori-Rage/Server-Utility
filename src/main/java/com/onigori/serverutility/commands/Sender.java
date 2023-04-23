package com.onigori.serverutility.commands;

import com.onigori.serverutility.objects.Rank;

import java.util.Locale;

public interface Sender {

	void sendTranslated(String message, boolean prefix);

	void sendMessage(String key, boolean prefix, Object... args);

	void sendMessageIncludingBlank(String key, boolean prefix, Object... args);

	Rank getRank();

	Locale getLocale();

	void setLocale(Locale locale);

	boolean isPlayer();

	String getName();

}

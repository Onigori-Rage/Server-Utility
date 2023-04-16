package com.onigori.serverutility.commands;

import com.onigori.serverutility.objects.players.Rank;

import java.util.Locale;

public interface Sender {

	void sendTranslated(String message, boolean prefix);

	void sendMessage(String key, boolean prefix, String... args);

	Rank getRank();

	Locale getLocale();

	void setLocale(Locale locale);

	boolean isPlayer();

	String getName();

}

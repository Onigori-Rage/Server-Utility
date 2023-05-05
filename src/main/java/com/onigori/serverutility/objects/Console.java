package com.onigori.serverutility.objects;

import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.Symbols;
import com.onigori.serverutility.apis.SUtilAddon;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.modules.LocalizedUtils;

import java.util.Locale;

public class Console implements Sender {

	private Locale locale = Symbols.DEFAULT_LOCALE;

	@Override
	public void sendTranslated(String message, boolean prefix) {
		SUtilMain.getConsole().sendMessage(prefix ? Symbols.PREFIX + message : message);
	}

	@Override
	public void sendMessage(String key, boolean prefix, Object... args) {
		this.sendTranslated(LocalizedUtils.getLocalizedMessage(key, this.locale, args), prefix);
	}

	@Override
	public void sendMessageIncludingBlank(String key, boolean prefix, Object... args) {

		boolean isFirst = prefix;

		for (String message: LocalizedUtils.getLocalizedMessage(key, this.locale, args).split("\n")) {

			sendTranslated(message, isFirst);

			isFirst = false;
		}

	}

	@Override
	public void sendAddonMessage(String key, SUtilAddon addon, boolean prefix, Object... args) {
		sendTranslated(addon.getLocalizedMessage(key, locale, args), prefix);
	}

	@Override
	public void sendAddonMessageIncludingBlank(String key, SUtilAddon addon, boolean prefix, Object... args) {

		boolean isFirst = prefix;

		for (final String message : addon.getLocalizedMessage(key, locale, args).split("\n")) {

			sendTranslated(message, isFirst);

			isFirst = false;
		}

	}

	@Override
	public String getName() {
		return Symbols.CONSOLE_NAME;
	}

	@Override
	public Rank getRank() {
		return Symbols.CONSOLE_RANK;
	}

	@Override
	public boolean isPlayer() {
		return false;
	}

	@Override
	public Locale getLocale() {
		return this.locale;
	}

	@Override
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

}

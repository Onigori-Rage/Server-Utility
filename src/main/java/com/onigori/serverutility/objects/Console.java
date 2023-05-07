package com.onigori.serverutility.objects;

import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.Symbols;
import com.onigori.serverutility.apis.SUtilAddon;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.utils.commons.LocalizedUtil;

import java.util.Locale;

public class Console implements Sender {

	@Override
	public void sendTranslated(String message, boolean prefix) {
		SUtilMain.getConsole().sendMessage(prefix ? Symbols.PREFIX + message : message);
	}

	@Override
	public void sendMessage(String key, boolean prefix, Object... args) {
		this.sendTranslated(LocalizedUtil.getLocalizedMessage(key, SUtilMain.getLocale(), args), prefix);
	}

	@Override
	public void sendMessageIncludingBlank(String key, boolean prefix, Object... args) {

		boolean isFirst = prefix;

		for (String message: LocalizedUtil.getLocalizedMessage(key, SUtilMain.getLocale(), args).split("\n")) {

			sendTranslated(message, isFirst);

			isFirst = false;
		}

	}

	@Override
	public void sendAddonMessage(String key, SUtilAddon addon, boolean prefix, Object... args) {
		sendTranslated(addon.getLocalizedMessage(key, SUtilMain.getLocale(), args), prefix);
	}

	@Override
	public void sendAddonMessageIncludingBlank(String key, SUtilAddon addon, boolean prefix, Object... args) {

		boolean isFirst = prefix;

		for (final String message : addon.getLocalizedMessage(key, SUtilMain.getLocale(), args).split("\n")) {

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
		return SUtilMain.getLocale();
	}

	@Override
	public void setLocale(Locale locale) {
		SUtilMain.setLocale(locale);
	}

}

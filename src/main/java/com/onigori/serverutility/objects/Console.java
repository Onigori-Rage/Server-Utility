package com.onigori.serverutility.objects;

import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.Symbols;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.modules.LocalizedMessage;

import java.util.Locale;

public class Console implements Sender {

	private Locale locale = Symbols.DEFAULT_LOCALE;

	@Override
	public void sendTranslated(String message, boolean prefix) {
		SUtilMain.getConsole().sendMessage(prefix ? Symbols.PREFIX + message : message);
	}

	@Override
	public void sendMessage(String key, boolean prefix, String... args) {
		this.sendTranslated(LocalizedMessage.getLocalizedMessage(key, this.locale, args), prefix);
	}

	@Override
	public String getName() {
		return Symbols.CONSOLE_NAME;
	}

	@Override
	public Permission getPermission() {
		return Permission.HIGHEST;
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

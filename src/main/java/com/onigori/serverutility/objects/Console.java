package com.onigori.serverutility.objects;

import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.Symbols;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.modules.LocalizedMessage;

public class Console implements Sender {

	@Override
	public void sendTranslated(String message, boolean prefix) {
		SUtilMain.getConsole().sendMessage(prefix ? Symbols.PREFIX + message : message);
	}

	@Override
	public void sendMessage(String key, boolean prefix, String... args) {
		this.sendTranslated(LocalizedMessage.getLocalizedMessage(key, args), prefix);
	}

	@Override
	public Permission getPermission() {
		return Permission.HIGHEST;
	}

}

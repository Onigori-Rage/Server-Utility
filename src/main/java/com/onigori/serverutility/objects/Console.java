package com.onigori.serverutility.objects;

import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.modules.LocalizedMessage;

public class Console implements Sender {

	@Override
	public void sendTranslated(String message) {
		SUtilMain.getConsole().sendMessage(message);
	}

	@Override
	public void sendMessage(String key, String... args) {
		this.sendTranslated(LocalizedMessage.getLocalizedMessage(key, args));
	}

	@Override
	public Permission getPermission() {
		return Permission.HIGHEST;
	}

}

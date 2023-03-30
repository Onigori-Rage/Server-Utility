package com.onigori.serverutility.commands;

import com.onigori.serverutility.objects.Permission;

public interface Sender {

	void sendTranslated(String message, boolean prefix);

	void sendMessage(String key, boolean prefix, String... args);

	Permission getPermission();

}

package com.onigori.serverutility.commands;

import com.onigori.serverutility.objects.Permission;

public interface Sender {

	void sendTranslated(String message);

	void sendMessage(String key, String... args);

	Permission getPermission();

}

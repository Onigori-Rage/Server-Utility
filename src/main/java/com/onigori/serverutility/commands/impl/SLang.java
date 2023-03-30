package com.onigori.serverutility.commands.impl;

import com.onigori.serverutility.commands.AbstractCommand;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.modules.LocalizedMessage;
import com.onigori.serverutility.objects.Permission;

import java.util.Locale;

public class SLang extends AbstractCommand {

	public SLang() {
		super("slang", "command-slang-usage", "command-slang-description", Permission.NORMAL);
	}

	@Override
	public void execute(Sender sender, String[] args) {
		if (args.length >= 1) {
			if (args[0].equalsIgnoreCase("English")) {
				LocalizedMessage.setLocale(Locale.ENGLISH);
				sender.sendMessage("command-slang-success", true, "English");
			}
			else if (args[0].equalsIgnoreCase("Japanese")) {
				LocalizedMessage.setLocale(Locale.JAPANESE);
				sender.sendMessage("command-slang-success", true, "Japanese");
			}

			else {
				sender.sendMessage(this.getUsageKey(), true);
			}
		}
		else {
			sender.sendMessage(this.getUsageKey(), true);
		}
	}

}

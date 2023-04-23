package com.onigori.serverutility.commands.impl;

import com.onigori.serverutility.commands.Command;
import com.onigori.serverutility.commands.CommandHandler;
import com.onigori.serverutility.commands.Sender;

import java.util.Locale;

public class Lang extends Command {

	public Lang() {
		super("lang", "command-lang-usage", "command-lang-description", CommandHandler.LANG_VALUE);
	}

	@Override
	public void execute(Sender sender, String[] args) {
		if (args.length >= 1) {
			String messageKey = "command-lang-success";

			switch (args[0].toLowerCase()) {
				case "english":
					sender.setLocale(Locale.ENGLISH);
					break;
				case "japanese":
					sender.setLocale(Locale.JAPANESE);
					break;
				default:
					messageKey = this.getUsageKey();
					break;

			}

			sender.sendMessage(messageKey, true);

			return;
		}
		sender.sendMessage(this.getUsageKey(), true);
	}

}

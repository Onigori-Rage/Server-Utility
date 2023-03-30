package com.onigori.serverutility.commands.impl;

import com.onigori.serverutility.commands.Command;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.modules.LocalizedMessage;
import com.onigori.serverutility.objects.Permission;

import java.util.Locale;

public class Punish extends Command {

	public Punish() {
		super("spunish", "usageKey", "descriptionKey", Permission.HIGHEST);
	}

	@Override
	public void execute(Sender sender, String[] args) {

	}

}

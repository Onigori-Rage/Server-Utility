package com.onigori.serverutility.commands.impl;

import com.onigori.serverutility.commands.Command;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.commands.SubCommand;
import com.onigori.serverutility.objects.Permission;

import java.util.concurrent.ConcurrentHashMap;

public class Punish extends Command {

	private final ConcurrentHashMap<String, SubCommand> subcommands = new ConcurrentHashMap<>();

	public Punish() {
		super("spunish", "usageKey", "descriptionKey", Permission.HIGHEST);
	}

	@Override
	public void execute(Sender sender, String[] args) {

	}

}

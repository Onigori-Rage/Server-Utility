package com.onigori.serverutility.commands;

import com.onigori.serverutility.objects.Permission;
import org.bukkit.command.CommandSender;

public abstract class AbstractCommand {

	private final String name;

	private final String usageKey;

	private final String descriptionKey;

	private final Permission permission;

	public AbstractCommand(String name, String usageKey, String descriptionKey, Permission permission) {
		this.name = name;
		this.usageKey = usageKey;
		this.descriptionKey = descriptionKey;
		this.permission = permission;
	}

	public Permission getPermission() {
		return this.permission;
	}

	public String getName() {
		return this.name;
	}

	public abstract void execute(Sender sender, String[] args);

}

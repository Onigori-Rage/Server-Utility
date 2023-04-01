package com.onigori.serverutility.commands;

import com.onigori.serverutility.objects.Permission;

public abstract class Command {

	private final String name;

	private final String usageKey;

	private final String descriptionKey;

	private final Permission permission;

	public Command(String name, String usageKey, String descriptionKey, Permission permission) {
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

	public String getUsageKey() {
		return this.usageKey;
	}

	public String getDescriptionKey() {
		return this.descriptionKey;
	}

	public abstract void execute(Sender sender, String[] args);

}

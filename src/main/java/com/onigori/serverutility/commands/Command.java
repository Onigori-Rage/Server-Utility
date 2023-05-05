package com.onigori.serverutility.commands;

import com.onigori.serverutility.SUtilMain;

public abstract class Command {

	private final String name;

	private final String usageKey;

	private final String descriptionKey;

	private final int requiredValue;

	private boolean isAddonCommand = false;

	public Command(String name, String usageKey, String descriptionKey, int requiredValue) {
		this.name = name;
		this.usageKey = usageKey;
		this.descriptionKey = descriptionKey;

		this.requiredValue = requiredValue;
	}

	public Command() {
		this.name = null;

		this.usageKey = null;
		this.descriptionKey = null;
		this.requiredValue = 0;
	}

	public final int getRequiredValue() {
		return this.requiredValue;
	}

	public final String getName() {
		return this.name;
	}

	public final String getUsageKey() {
		return this.usageKey;
	}

	public final String getDescriptionKey() {
		return this.descriptionKey;
	}

	public abstract void execute(Sender sender, String[] args);

	public boolean isAddonCommand() {
		return this.isAddonCommand;
	}

	public void makeAddonCommand() {
		this.isAddonCommand = true;
	}

}

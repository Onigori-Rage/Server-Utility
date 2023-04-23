package com.onigori.serverutility.commands;

import com.onigori.serverutility.SUtilMain;

public abstract class Command {

	private final String name;

	private final String usageKey;

	private final String descriptionKey;

	private int requiredValue;

	public Command(String name, String usageKey, String descriptionKey) {
		this.name = name;
		this.usageKey = usageKey;
		this.descriptionKey = descriptionKey;

		this.requiredValue = SUtilMain.getInstance().getConfig().getInt("commands." + name);
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

}

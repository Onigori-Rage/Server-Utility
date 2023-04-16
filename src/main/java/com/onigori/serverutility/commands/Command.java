package com.onigori.serverutility.commands;

public abstract class Command {

	private final String name;

	private final String usageKey;

	private final String descriptionKey;

	private int requiredValue;

	public Command(String name, String usageKey, String descriptionKey, int requiredValue) {
		this.name = name;
		this.usageKey = usageKey;
		this.descriptionKey = descriptionKey;
		this.requiredValue = requiredValue;
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

package com.onigori.serverutility.objects.players;

public final class Rank {

	private String name;

	private String prefix;

	private int value;

	public Rank(String name, String prefix, int value) {
		this.name = name;

		this.prefix = prefix;

		this.value = value;
	}

	public String getName() {
		return this.name;
	}

	public String getPrefix() {
		return this.prefix;
	}

	public int getValue() {
		return this.value;
	}

	/*HIGHEST(100),
	NRMAL(0);

	private final int permission;

	Permission(int permission) {
		this.permission = permission;
	}

	public int getPermissionValue() {
		return this.permission;
	}

	Utilities.
	public static boolean comparedPermission(Sender sender, Permission permission) {
		return sender.getPermission().getPermissionValue() >= permission.getPermissionValue();
	}
	*/

}

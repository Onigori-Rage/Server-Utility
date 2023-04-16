package com.onigori.serverutility.objects;

import net.md_5.bungee.api.ChatColor;

public final class Rank {

	private String name;

	private String rawPrefix;

	private String prefix;

	private int value;

	private boolean isToBeRemoved = false;

	public Rank(String name, String rawPrefix, int value) {
		this.name = name;

		this.rawPrefix = rawPrefix;

		this.prefix = ChatColor.translateAlternateColorCodes('&', rawPrefix);

		this.value = value;
	}

	public String getName() {
		return this.name;
	}

	public boolean isToBeRemoved() {
		return this.isToBeRemoved;
	}

	public String getPrefix() {
		return this.prefix;
	}

	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getRawPrefix() {
		return this.rawPrefix;
	}

	public void setPrefix(String rawPrefix) {
		this.rawPrefix = rawPrefix;

		this.prefix = ChatColor.translateAlternateColorCodes('&', rawPrefix);
	}

	public void remove() {
		this.isToBeRemoved = true;
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

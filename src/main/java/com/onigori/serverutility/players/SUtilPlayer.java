package com.onigori.serverutility.players;

import com.onigori.serverutility.objects.Permission;

import java.util.UUID;

public class SUtilPlayer {

	private UUID uuid;

	private String name;

	private Permission permission;

	private Punishment punishment;

	public SUtilPlayer(UUID uuid, String name, Permission permission, Punishment punishment) {
		this.uuid = uuid;
		this.name = name;
		this.permission = permission;
		this.punishment = punishment;
	}

	public UUID getUUID() {
		return this.uuid;
	}

}

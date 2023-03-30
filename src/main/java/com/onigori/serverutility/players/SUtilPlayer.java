package com.onigori.serverutility.players;

import com.onigori.serverutility.objects.Permission;
import org.bukkit.entity.Player;

import java.util.UUID;

public class SUtilPlayer {

	private UUID uuid;

	private String name;

	private Permission permission;

	private Punishment punishment;

	private Player corePlayer;

	public SUtilPlayer(UUID uuid, String name, Permission permission, Punishment punishment) {
		this.uuid = uuid;
		this.name = name;
		this.permission = permission;
		this.punishment = punishment;
	}

	public UUID getUUID() {
		return this.uuid;
	}

	public Punishment getPunishment() {
		return this.punishment;
	}

	public Permission getPermission() {
		return this.permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public void updatePlayer(Player player) {
		this.corePlayer = player;
	}

	public void sendMessage(String key, String... args) {
		this.sendTranslated(null);
	}

	public void sendTranslated(String message) {
		if (this.corePlayer != null) {
			this.corePlayer.sendMessage(message);
		}
	}

}

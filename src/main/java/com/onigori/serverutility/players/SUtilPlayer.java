package com.onigori.serverutility.players;

import com.onigori.serverutility.Symbols;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.modules.LocalizedMessage;
import com.onigori.serverutility.objects.Permission;
import org.bukkit.entity.Player;

import java.util.UUID;

public class SUtilPlayer implements Sender {

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

	@Override
	public Permission getPermission() {
		return this.permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public void updatePlayer(Player player) {
		this.corePlayer = player;
	}

	@Override
	public void sendMessage(String key, boolean prefix, String... args) {
		this.sendTranslated(LocalizedMessage.getLocalizedMessage(key, args), prefix);
	}

	@Override
	public void sendTranslated(String message, boolean prefix) {
		if (this.corePlayer != null) {
			this.corePlayer.sendMessage(prefix ? Symbols.PREFIX + message : message);
		}
	}

}

package com.onigori.serverutility.players;

import com.onigori.serverutility.Symbols;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.modules.LocalizedMessage;
import com.onigori.serverutility.objects.Permission;
import org.bukkit.entity.Player;

import java.util.Locale;
import java.util.UUID;

public class SUtilPlayer implements Sender {

	private UUID uuid;

	private String name;

	private Permission permission;

	private Punishment punishment;

	private Locale locale = Symbols.DEFAULT_LOCALE;

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

	@Override
	public Locale getLocale() {
		return this.locale;
	}

	@Override
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public void updatePlayer(Player player) {
		this.corePlayer = player;
	}

	@Override
	public void sendMessage(String key, boolean prefix, String... args) {
		this.sendTranslated(LocalizedMessage.getLocalizedMessage(key, this.locale, args), prefix);
	}

	@Override
	public void sendTranslated(String message, boolean prefix) {
		if (this.corePlayer != null) {
			this.corePlayer.sendMessage(prefix ? Symbols.PREFIX + message : message);
		}
	}

}

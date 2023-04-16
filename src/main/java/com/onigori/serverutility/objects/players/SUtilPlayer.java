package com.onigori.serverutility.objects.players;

import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.Symbols;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.modules.LocalizedMessage;
import com.onigori.serverutility.objects.punishments.Ban;
import com.onigori.serverutility.objects.punishments.Kick;
import com.onigori.serverutility.objects.punishments.Mute;
import com.onigori.serverutility.objects.punishments.Warn;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Locale;
import java.util.UUID;

public class SUtilPlayer implements Sender {

	private UUID uuid;

	private String name;

	private Rank rank;

	private PunishmentContainer punishmentContainer;

	private Locale locale = Symbols.DEFAULT_LOCALE;

	private Player corePlayer;

	public SUtilPlayer(UUID uuid, String name, Rank rank, PunishmentContainer punishmentContainer) {
		this.uuid = uuid;
		this.name = name;
		this.rank = rank;
		this.punishmentContainer = punishmentContainer;
	}

	public UUID getUUID() {
		return this.uuid;
	}

	@Override
	public boolean isPlayer() {
		return true;
	}

	@Override
	public String getName() {
		return this.name;
	}

	public Player getCore() {
		return this.corePlayer;
	}

	public PunishmentContainer getPunishment() {
		return this.punishmentContainer;
	}

	@Override
	public Rank getRank() {
		return this.rank;
	}

	@Override
	public Locale getLocale() {
		return this.locale;
	}

	@Override
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
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

	public boolean kick(Kick kick) {
		if (this.corePlayer != null) {
			Bukkit.getScheduler().runTask(SUtilMain.getInstance(), () ->
					this.corePlayer.kickPlayer(LocalizedMessage.getLocalizedMessage("kick-message", this.locale, Symbols.PREFIX, kick.getExecutor().getName(), kick.getReason()))
			);

			return true;
		}

		return false;
	}

	public boolean warn(Warn warn) {
		if (this.corePlayer != null) {
			this.sendMessage("warn-message", false, Symbols.PREFIX, warn.getExecutor().getName(), warn.getReason());

			return true;
		}

		return false;
	}

	public void ban(Ban ban) {
		this.kick(new Kick(ban.getReason(), ban.getExecutor(), ban.getTarget()));

		this.punishmentContainer.setBan(ban);
	}

	public void mute(Mute mute) {
		this.punishmentContainer.setMute(mute);
	}

}

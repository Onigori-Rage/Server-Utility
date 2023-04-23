package com.onigori.serverutility.objects.punishments;

import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.modules.LocalizedMessage;
import com.onigori.serverutility.objects.players.SUtilPlayer;
import org.apache.commons.lang3.time.DurationFormatUtils;

import java.util.Date;

public abstract class Punishment {

	private final PunishmentType type;

	private final String reason;

	private final Sender executor;

	private SUtilPlayer target;

	private final boolean isRecordable;

	private final Date expiration;

	private final boolean isTemporary;

	public Punishment(PunishmentType type, String reason, Sender executor, SUtilPlayer target, boolean isRecordable, boolean isTemporary, Date expiration) {
		this.type = type;

		this.reason = reason;

		this.executor = executor;
		this.target = target;

		this.isRecordable = isRecordable;

		this.expiration = expiration;

		this.isTemporary = isTemporary;
	}

	public final boolean isRecordable() {
		return this.isRecordable;
	}

	public final PunishmentType getType() {
		return type;
	}

	public final String getReason() {
		return reason;
	}

	public final Sender getExecutor() {
		return executor;
	}

	public final SUtilPlayer getTarget() {
		return target;
	}

	/*
	Return: Whether he/she is to be kept away from the server.
	 */
	public final boolean checkExpiration() {
		return !this.isTemporary || expiration.after(new Date());

	}

	public abstract boolean execute();

	public final void queue() {
		boolean result = this.execute();

		executor.sendMessage("command-punish-" + type.name().toLowerCase() + "-" + (result ? "success" : "failed"), true, this.target.getName());
	}

	public final Date getExpiration() {
		return expiration;
	}

	public final String getExpirationAsString() {
		if (!isTemporary) {
			return LocalizedMessage.getLocalizedMessage("expiration-permanent", target.getLocale());
		}

		return DurationFormatUtils.formatPeriod(new Date().getTime(), this.expiration.getTime(), LocalizedMessage.getLocalizedMessage("expiration-format", target.getLocale()));
	}

	public final boolean isTemporary() {
		return isTemporary;
	}

}

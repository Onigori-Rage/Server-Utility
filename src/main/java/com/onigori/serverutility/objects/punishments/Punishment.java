package com.onigori.serverutility.objects.punishments;

import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.players.SUtilPlayer;

import java.util.Calendar;
import java.util.Date;

public abstract class Punishment {

	private PunishmentType type;

	private String reason;

	private Sender executor;

	private SUtilPlayer target;

	private final boolean isRecordable;

	private Date expire;

	private boolean isTemporary;

	public Punishment(PunishmentType type, String reason, Sender executor, SUtilPlayer target, boolean isRecordable, boolean isTemporary, Date expire) {
		this.type = type;

		this.reason = reason;

		this.executor = executor;
		this.target = target;

		this.isRecordable = isRecordable;

		this.expire = expire;

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
		return !this.isTemporary || expire.after(new Date());

	}

	public abstract boolean execute();

	public final void queue() {
		boolean result = this.execute();
		executor.sendMessage("command-spunish-" + type.name().toLowerCase() + "-" + (result ? "success" : "failed"), true, this.target.getName());
	}

	public final Date getExpire() {
		return expire;
	}

	public final boolean isTemporary() {
		return isTemporary;
	}
}

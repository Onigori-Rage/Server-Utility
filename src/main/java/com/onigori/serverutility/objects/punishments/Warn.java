package com.onigori.serverutility.objects.punishments;

import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.players.SUtilPlayer;

import java.util.Date;

public class Warn extends Punishment {

	public Warn(String reason, Sender executor, SUtilPlayer target) {
		super(PunishmentType.WARN, reason, executor, target, false, false, null);
	}

	@Override
	public boolean execute() {
		return getTarget().warn(getReason(), getExecutor().getName());
	}
}

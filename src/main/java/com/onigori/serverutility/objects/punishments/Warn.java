package com.onigori.serverutility.objects.punishments;

import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.objects.players.SUtilPlayer;

public class Warn extends Punishment {

	public Warn(String reason, Sender executor, SUtilPlayer target) {
		super(PunishmentType.WARN, reason, executor, target, false, false, null);
	}

	@Override
	public boolean execute() {
		return getTarget().warn(this);
	}
}

package com.onigori.serverutility.objects.punishments;

import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.players.SUtilPlayer;

import java.util.Date;

public class Ban extends Punishment {

	public Ban(String reason, Sender executor, SUtilPlayer target, Date expire) {
		super(PunishmentType.BAN, reason, executor, target, true, true, expire);
	}

	public Ban(String reason, Sender executor, SUtilPlayer target) {
		super(PunishmentType.BAN, reason, executor, target, true, false, null);
	}

	@Override
	public boolean execute() {
		getTarget().ban(this);

		return true;
	}

}

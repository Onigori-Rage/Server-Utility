package com.onigori.serverutility.objects.punishments;

import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.objects.players.SUtilPlayer;

public class Kick extends Punishment {

	public Kick(String reason, Sender executor, SUtilPlayer target) {
		super(PunishmentType.KICK, reason, executor, target, false, false, null);
	}

	@Override
	public boolean execute() {
		return getTarget().kick(this);
	}

}

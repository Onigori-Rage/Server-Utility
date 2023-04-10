package com.onigori.serverutility.objects.punishments;

import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.players.SUtilPlayer;

import java.util.Date;

public class Mute extends Punishment {

	public Mute(String reason, Sender executor, SUtilPlayer target, Date expire) {
		super(PunishmentType.MUTE, reason, executor, target, true, true, expire);
	}

	public Mute(String reason, Sender executor, SUtilPlayer target) {
		super(PunishmentType.MUTE, reason, executor, target, true, false, null);
	}

	@Override
	public boolean execute() {
		getTarget().mute(this);

		return true;
	}
}

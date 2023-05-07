package com.onigori.serverutility.objects.punishments.impl;

import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.objects.players.SUtilPlayer;
import com.onigori.serverutility.objects.punishments.Punishment;
import com.onigori.serverutility.objects.punishments.PunishmentType;

public class Warn extends Punishment {

	public Warn(String reason, Sender executor, SUtilPlayer target) {
		super(PunishmentType.WARN, reason, executor, target, false, false, null);
	}

	@Override
	public boolean execute() {
		return getTarget().warn(this);
	}

}

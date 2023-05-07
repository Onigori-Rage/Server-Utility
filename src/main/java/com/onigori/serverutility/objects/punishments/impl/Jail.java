package com.onigori.serverutility.objects.punishments.impl;

import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.objects.players.SUtilPlayer;
import com.onigori.serverutility.objects.punishments.Punishment;
import com.onigori.serverutility.objects.punishments.PunishmentType;

import java.util.Date;

public class Jail extends Punishment {

	public Jail(String reason, Sender executor, SUtilPlayer target, Date expire) {
		super(PunishmentType.JAIL, reason, executor, target, true, true, expire);
	}

	public Jail(String reason, Sender executor, SUtilPlayer target) {
		super(PunishmentType.JAIL, reason, executor, target, true, false, null);
	}

	@Override
	public boolean execute() {

		return true;
	}

}

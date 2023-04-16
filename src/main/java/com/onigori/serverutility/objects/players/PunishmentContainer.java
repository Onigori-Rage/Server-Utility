package com.onigori.serverutility.objects.players;

import com.onigori.serverutility.objects.punishments.Ban;
import com.onigori.serverutility.objects.punishments.Jail;
import com.onigori.serverutility.objects.punishments.Mute;

public class PunishmentContainer {

	private Ban availableBan;

	private Mute availableMute;

	private Jail availableJail;

	private boolean isJailedCached = false;

	public Ban getAvailableBan() {
		return availableBan;
	}

	public Mute getAvailableMute() {
		return this.availableMute;
	}

	public Jail getAvailableJail() {
		return this.availableJail;
	}

	public void setJail(Jail jail) {
		this.availableJail = jail;
	}

	public void setBan(Ban ban) {
		this.availableBan = ban;
	}

	public void setMute(Mute mute) {
		this.availableMute = mute;
	}

	public boolean isJailed() {
		return this.isJailedCached;
	}

}

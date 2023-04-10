package com.onigori.serverutility.players;

import com.onigori.serverutility.objects.punishments.Ban;
import com.onigori.serverutility.objects.punishments.Mute;

public class PunishmentContainer {

	private Ban availableBan;

	private Mute availableMute;

	public Ban getAvailableBan() {
		return availableBan;
	}

	public Mute getAvailableMute() {
		return this.availableMute;
	}

	public void setBan(Ban ban) {
		this.availableBan = ban;
	}

	public void setMute(Mute mute) {
		this.availableMute = mute;
	}

}

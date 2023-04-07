package com.onigori.serverutility.players;

import com.onigori.serverutility.objects.punishments.Ban;

public class PunishmentContainer {

	private Ban availableBan;

	public Ban getAvailableBan() {
		return availableBan;
	}

	public void setBan(Ban ban) {
		this.availableBan = ban;
	}

}

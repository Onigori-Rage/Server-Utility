package com.onigori.serverutility.objects.players;

import com.onigori.serverutility.objects.punishments.Ban;
import com.onigori.serverutility.objects.punishments.Jail;
import com.onigori.serverutility.objects.punishments.Mute;

import java.util.LinkedList;

public class PunishmentContainer {

	private final LinkedList<Ban> bans = new LinkedList<>();

	private final LinkedList<Mute> mutes = new LinkedList<>();

	private final LinkedList<Jail> jails = new LinkedList<>();

	private Ban availableBan;

	private Mute availableMute;

	private Jail availableJail;

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

	public LinkedList<Ban> getBanHistory() {
		return this.bans;
	}

	public LinkedList<Mute> getMuteHistory() {
		return this.mutes;
	}

	public LinkedList<Jail> getJailHistory() {
		return this.jails;
	}

}

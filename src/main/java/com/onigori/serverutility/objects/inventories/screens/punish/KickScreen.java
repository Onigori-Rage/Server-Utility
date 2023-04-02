package com.onigori.serverutility.objects.inventories.screens.punish;

import com.onigori.api.guihelper.ItemBuilder;
import com.onigori.api.guihelper.components.OnigoriScreen;
import com.onigori.serverutility.modules.LocalizedMessage;
import com.onigori.serverutility.objects.inventories.handlers.Cancel;
import com.onigori.serverutility.objects.inventories.handlers.punish.TargetInfo;
import com.onigori.serverutility.objects.inventories.handlers.punish.kick.Accept;
import com.onigori.serverutility.objects.inventories.screens.PunishScreen;
import com.onigori.serverutility.players.SUtilPlayer;
import org.bukkit.Material;

public class KickScreen extends OnigoriScreen {

	private final SUtilPlayer executor;

	private final SUtilPlayer target;

	private final String reason;

	public KickScreen(SUtilPlayer executor, SUtilPlayer target, String reason) {
		super(3, LocalizedMessage.getLocalizedMessage("gui-punish-kick-displayname", executor.getLocale()));

		this.executor = executor;
		this.target = target;

		this.reason = reason;

		this.init();
	}

	public SUtilPlayer getTarget() {
		return this.target;
	}

	public SUtilPlayer getExecutor() {
		return this.executor;
	}

	public String getReason() {
		return reason;
	}

	@Override
	public void init() {

		this.setItem(
				new ItemBuilder(Material.EMERALD_BLOCK, 1).
						setName(LocalizedMessage.getLocalizedMessage("gui-punish-kick-accept-displayname", this.executor.getLocale())).
						setDescription(LocalizedMessage.getLocalizedMessage("gui-punish-kick-accept-lore", this.executor.getLocale())).
						setListener(new Accept()).
						build()
				, 11
		);

		this.setItem(
				new ItemBuilder(Material.REDSTONE_BLOCK, 1).
						setName(LocalizedMessage.getLocalizedMessage("gui-punish-kick-deny-displayname", this.executor.getLocale())).
						setDescription(LocalizedMessage.getLocalizedMessage("gui-punish-kick-deny-lore", this.executor.getLocale())).
						setListener(new Cancel()).
						build()
				, 15
		);

		this.setItem(
				new ItemBuilder(Material.SKULL_ITEM, 1).
						setName(LocalizedMessage.getLocalizedMessage("gui-punish-targetinfo-displayname", this.executor.getLocale())).
						setListener(new TargetInfo()).
						setDescription(
								LocalizedMessage.
										getLocalizedMessage("gui-punish-targetinfo-lore",
												this.executor.getLocale(),
												this.target.getName(),
												this.target.getUUID().toString(),
												this.target.getPermission().name())
						).
						mergeSkull(this.target.getUUID()).
						build()
				, 13);

		this.setItem(
				new ItemBuilder(Material.NAME_TAG, 1).
						setName(LocalizedMessage.getLocalizedMessage("gui-punish-reason-displayname", this.executor.getLocale())).
						setDescription(LocalizedMessage.getLocalizedMessage("gui-punish-reason-lore", this.executor.getLocale(), this.reason)).
						build()
				, 8
		);

	}

}

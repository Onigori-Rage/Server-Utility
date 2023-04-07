package com.onigori.serverutility.objects.inventories.screens;

import com.onigori.api.guihelper.ItemBuilder;
import com.onigori.api.guihelper.components.OnigoriScreen;
import com.onigori.api.guihelper.components.ReturnableScreen;
import com.onigori.api.guihelper.components.TargetableScreen;
import com.onigori.serverutility.modules.LocalizedMessage;
import com.onigori.serverutility.objects.inventories.handlers.Cancel;
import com.onigori.serverutility.objects.inventories.handlers.TargetInfo;
import com.onigori.serverutility.objects.inventories.handlers.punish.BanOpener;
import com.onigori.serverutility.objects.inventories.handlers.punish.KickOpener;
import com.onigori.serverutility.objects.inventories.handlers.punish.MuteOpener;
import com.onigori.serverutility.objects.inventories.handlers.punish.WarnOpener;
import com.onigori.serverutility.objects.inventories.screens.punish.ScreenType;
import com.onigori.serverutility.players.SUtilPlayer;
import org.bukkit.Material;

import java.util.Date;

public class PunishScreen extends OnigoriScreen implements ReturnableScreen, TargetableScreen {

	private final SUtilPlayer executor;

	private final SUtilPlayer target;

	private OnigoriScreen previousScreen;

	private final ScreenType screenType;

	private String reason;

	private int expire;

	public PunishScreen(SUtilPlayer executor, SUtilPlayer target, String reason, ScreenType screenType, OnigoriScreen previousScreen) {
		super(screenType.getRow(), LocalizedMessage.getLocalizedMessage(screenType.getDisplayKey(), executor.getLocale()));

		this.executor = executor;
		this.target = target;

		this.reason = reason;

		this.previousScreen = previousScreen;

		this.screenType = screenType;

		if (screenType == ScreenType.BOSS) {
			this.init();
		}
	}

	public String getReason() {
		return this.reason;
	}

	public int getExpire() {
		return this.expire;
	}

	@Override
	public void init() {
		// Target Info
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
		, 22);

		// Cancel
		this.setItem(
				new ItemBuilder(Material.BARRIER, 1).
						setName(LocalizedMessage.getLocalizedMessage("gui-global-cancel-displayname", this.executor.getLocale())).
						setDescription(LocalizedMessage.getLocalizedMessage("gui-global-cancel-lore", this.executor.getLocale())).
						setListener(new Cancel()).
						build()
				, 44
		);

		//Ban

		this.setItem(
				new ItemBuilder(Material.LAVA_BUCKET, 1).
						setName(LocalizedMessage.getLocalizedMessage("gui-punish-banaction-displayname", this.executor.getLocale())).
						setDescription(LocalizedMessage.getLocalizedMessage("gui-punish-banaction-lore", this.executor.getLocale())).
						setListener(new BanOpener()).
						build()
				, 19
		);

		//Mute

		this.setItem(
				new ItemBuilder(Material.REDSTONE_BLOCK, 1).
						setName(LocalizedMessage.getLocalizedMessage("gui-punish-muteaction-displayname", this.executor.getLocale())).
						setDescription(LocalizedMessage.getLocalizedMessage("gui-punish-muteaction-lore", this.executor.getLocale())).
						setListener(new MuteOpener()).
						build()
				, 25
		);

		//KickOpener

		this.setItem(
				new ItemBuilder(Material.DISPENSER, 1).
						setName(LocalizedMessage.getLocalizedMessage("gui-punish-kickaction-displayname", this.executor.getLocale())).
						setDescription(LocalizedMessage.getLocalizedMessage("gui-punish-kickaction-lore", this.executor.getLocale())).
						setListener(new KickOpener()).
						build()
				, 4
		);

		//WarnOpener

		this.setItem(
				new ItemBuilder(Material.REDSTONE_TORCH_ON, 1).
						setName(LocalizedMessage.getLocalizedMessage("gui-punish-warnaction-displayname", this.executor.getLocale())).
						setDescription(LocalizedMessage.getLocalizedMessage("gui-punish-warnaction-lore", this.executor.getLocale())).
						setListener(new WarnOpener()).
						build()
				, 40
		);

		//Reasoning

		this.setItem(
				new ItemBuilder(Material.NAME_TAG, 1).
						setName(LocalizedMessage.getLocalizedMessage("gui-punish-reason-displayname", this.executor.getLocale())).
						setDescription(LocalizedMessage.getLocalizedMessage("gui-punish-reason-lore", this.executor.getLocale(), this.reason)).
						build()
				, 8
		);

	}

	public SUtilPlayer getExecutor() {
		return this.executor;
	}

	@Override
	public SUtilPlayer getTarget() {
		return this.target;
	}

	public ScreenType getScreenType() {
		return this.screenType;
	}

	@Override
	public OnigoriScreen getPreviousScreen() {
		return this.previousScreen;
	}

}

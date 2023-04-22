package com.onigori.serverutility.objects.inventories.screens;

import com.onigori.api.guihelper.ItemBuilder;
import com.onigori.api.guihelper.components.OnigoriScreen;
import com.onigori.api.guihelper.components.ReturnableScreen;
import com.onigori.api.guihelper.components.TargetableScreen;
import com.onigori.serverutility.modules.LocalizedMessage;
import com.onigori.serverutility.objects.inventories.handlers.Cancel;
import com.onigori.serverutility.objects.inventories.handlers.TargetInfo;
import com.onigori.serverutility.objects.inventories.handlers.punish.opener.BanOpener;
import com.onigori.serverutility.objects.inventories.handlers.punish.opener.KickOpener;
import com.onigori.serverutility.objects.inventories.handlers.punish.opener.MuteOpener;
import com.onigori.serverutility.objects.inventories.handlers.punish.opener.WarnOpener;
import com.onigori.serverutility.objects.inventories.screens.punish.ScreenType;
import com.onigori.serverutility.objects.players.SUtilPlayer;
import org.bukkit.Material;
import org.bukkit.event.inventory.ClickType;

import java.util.Locale;

public class PunishScreen extends OnigoriScreen implements ReturnableScreen, TargetableScreen {

	private final SUtilPlayer executor;

	private final SUtilPlayer target;

	private OnigoriScreen previousScreen;

	private final ScreenType screenType;

	private String reason;

	private int expiration = 0;

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

	public final String getReason() {
		return this.reason;
	}

	public final int getExpiration() {
		return this.expiration;
	}

	public final int adjustExpiration(ClickType type) {
		final int variation = type.isShiftClick() ? 14: 1;

		this.expiration = expiration + (type.isLeftClick() ? variation : -variation);

		/*
		Checker below.
		 */

		if (this.expiration < 0) {
			this.expiration = 0;
		}

		return this.expiration;

	}

	@Override
	public void init() {

		final Locale locale = this.executor.getLocale();

		// Target Info
		this.setItem(
				new ItemBuilder(Material.SKULL_ITEM, 1).
						setName(LocalizedMessage.getLocalizedMessage("gui-punish-targetinfo-displayname", locale)).
						setListener(new TargetInfo()).
						setDescription(
								LocalizedMessage.
										getLocalizedMessage("gui-punish-targetinfo-lore",
												locale,
												this.target.getName(),
												this.target.getUUID().toString(),
												this.target.getRank().getName())
						).
				mergeSkull(this.target.getUUID()).
				build()
		, 22);

		// Cancel
		this.setItem(
				new ItemBuilder(Material.BARRIER, 1).
						setName(LocalizedMessage.getLocalizedMessage("gui-global-cancel-displayname", locale)).
						setDescription(LocalizedMessage.getLocalizedMessage("gui-global-cancel-lore", locale)).
						setListener(new Cancel()).
						build()
				, 44
		);

		//Ban

		this.setItem(
				new ItemBuilder(Material.LAVA_BUCKET, 1).
						setName(LocalizedMessage.getLocalizedMessage("gui-punish-banaction-displayname", locale)).
						setDescription(LocalizedMessage.getLocalizedMessage("gui-punish-banaction-lore", locale)).
						setListener(new BanOpener()).
						build()
				, 19
		);

		//JailOpener
		this.setItem(
				new ItemBuilder(Material.IRON_FENCE, 1).
						setName(LocalizedMessage.getLocalizedMessage("gui-punish-jailaction-displayname", locale)).
						setDescription(LocalizedMessage.getLocalizedMessage("gui-punish-jailaction-lore", locale)).
						build()
				, 11
		);

		//Mute

		this.setItem(
				new ItemBuilder(Material.REDSTONE_BLOCK, 1).
						setName(LocalizedMessage.getLocalizedMessage("gui-punish-muteaction-displayname", locale)).
						setDescription(LocalizedMessage.getLocalizedMessage("gui-punish-muteaction-lore", locale)).
						setListener(new MuteOpener()).
						build()
				, 25
		);

		//KickOpener

		this.setItem(
				new ItemBuilder(Material.DISPENSER, 1).
						setName(LocalizedMessage.getLocalizedMessage("gui-punish-kickaction-displayname", locale)).
						setDescription(LocalizedMessage.getLocalizedMessage("gui-punish-kickaction-lore", locale)).
						setListener(new KickOpener()).
						build()
				, 4
		);

		//WarnOpener

		this.setItem(
				new ItemBuilder(Material.REDSTONE_TORCH_ON, 1).
						setName(LocalizedMessage.getLocalizedMessage("gui-punish-warnaction-displayname", locale)).
						setDescription(LocalizedMessage.getLocalizedMessage("gui-punish-warnaction-lore", locale)).
						setListener(new WarnOpener()).
						build()
				, 40
		);

		//Reasoning

		this.setItem(
				new ItemBuilder(Material.NAME_TAG, 1).
						setName(LocalizedMessage.getLocalizedMessage("gui-punish-reason-displayname", locale)).
						setDescription(LocalizedMessage.getLocalizedMessage("gui-punish-reason-lore", locale, this.reason)).
						build()
				, 8
		);

	}

	public final SUtilPlayer getExecutor() {
		return this.executor;
	}

	@Override
	public final SUtilPlayer getTarget() {
		return this.target;
	}

	public final ScreenType getScreenType() {
		return this.screenType;
	}

	@Override
	public final OnigoriScreen getPreviousScreen() {
		return this.previousScreen;
	}

}

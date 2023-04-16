package com.onigori.serverutility.objects.inventories.screens.punish;

import com.onigori.api.guihelper.ItemBuilder;
import com.onigori.api.guihelper.components.OnigoriScreen;
import com.onigori.serverutility.modules.LocalizedMessage;
import com.onigori.serverutility.objects.inventories.handlers.Cancel;
import com.onigori.serverutility.objects.inventories.handlers.Return;
import com.onigori.serverutility.objects.inventories.handlers.TargetInfo;
import com.onigori.serverutility.objects.inventories.handlers.punish.DaySelector;
import com.onigori.serverutility.objects.inventories.handlers.punish.PunishAccept;
import com.onigori.serverutility.objects.inventories.screens.PunishScreen;
import com.onigori.serverutility.objects.players.SUtilPlayer;
import org.bukkit.Material;

import java.util.Locale;

public class BanScreen extends PunishScreen {

	public BanScreen(SUtilPlayer executor, SUtilPlayer target, String reason, OnigoriScreen previousScreen) {
		super(executor, target, reason, ScreenType.BAN, previousScreen);

		this.init();
	}

	@Override
	public void init() {
		final Locale locale = this.getExecutor().getLocale();

		this.setItem(
				new ItemBuilder(Material.EMERALD_BLOCK, 1).
						setName(LocalizedMessage.getLocalizedMessage("gui-punish-ban-accept-displayname", locale)).
						setDescription(LocalizedMessage.getLocalizedMessage("gui-punish-ban-accept-lore", locale)).
						setListener(new PunishAccept()).
						build()
				, 11
		);

		this.setItem(
				new ItemBuilder(Material.REDSTONE_BLOCK, 1).
						setName(LocalizedMessage.getLocalizedMessage("gui-global-cancel-displayname", locale)).
						setDescription(LocalizedMessage.getLocalizedMessage("gui-global-cancel-lore", locale)).
						setListener(new Cancel()).
						build()
				, 15
		);

		this.setItem(
				new ItemBuilder(Material.SKULL_ITEM, 1).
						setName(LocalizedMessage.getLocalizedMessage("gui-punish-targetinfo-displayname", locale)).
						setListener(new TargetInfo()).
						setDescription(
								LocalizedMessage.
										getLocalizedMessage("gui-punish-targetinfo-lore",
												locale,
												this.getTarget().getName(),
												this.getTarget().getUUID().toString(),
												this.getTarget().getPermission().name())
						).
						mergeSkull(this.getTarget().getUUID()).
						build()
				, 13
		);

		this.setItem(
				new ItemBuilder(Material.ARROW, 1).
						setName(LocalizedMessage.getLocalizedMessage("gui-global-return-displayname", locale)).
						setDescription(LocalizedMessage.getLocalizedMessage("gui-global-return-lore", locale)).
						setListener(new Return()).
						build()
				, 18
		);

		this.setItem(
				new ItemBuilder(Material.NAME_TAG, 1).
						setName(LocalizedMessage.getLocalizedMessage("gui-punish-reason-displayname", locale)).
						setDescription(LocalizedMessage.getLocalizedMessage("gui-punish-reason-lore", locale, this.getReason())).
						build()
				, 8
		);


		this.setItem(
				new ItemBuilder(Material.WATCH, 1).
						setName(LocalizedMessage.getLocalizedMessage("gui-punish-expirationselector-displayname", locale)).
						setDescription(LocalizedMessage.getLocalizedMessage("gui-punish-expirationselector-lore", locale, String.valueOf(this.getExpiration()))).
						setListener(new DaySelector()).
						build()
				, 0
		);

	}

}

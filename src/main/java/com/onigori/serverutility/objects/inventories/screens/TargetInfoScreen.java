package com.onigori.serverutility.objects.inventories.screens;

import com.onigori.api.guihelper.ItemBuilder;
import com.onigori.api.guihelper.components.OnigoriScreen;
import com.onigori.api.guihelper.components.ReturnableScreen;
import com.onigori.serverutility.utils.commons.LocalizedUtil;
import com.onigori.serverutility.objects.inventories.handlers.Return;
import com.onigori.serverutility.objects.players.SUtilPlayer;
import org.bukkit.Material;

import java.util.Locale;

public class TargetInfoScreen extends OnigoriScreen implements ReturnableScreen {

	private final SUtilPlayer target;

	private final Locale locale;

	private final OnigoriScreen previousScreen;

	public TargetInfoScreen(SUtilPlayer target, Locale locale, OnigoriScreen previousScreen) {
		super(5, LocalizedUtil.getLocalizedMessage("gui-targetinfo-displayname", locale));

		this.target = target;

		this.locale = locale;
		this.previousScreen = previousScreen;

		this.init();
	}

	@Override
	public void init() {
		this.setItem(
				new ItemBuilder(Material.SKULL_ITEM, 1).
						setName(LocalizedUtil.getLocalizedMessage("gui-punish-targetinfo-displayname", locale)).
						setDescription(
								LocalizedUtil.
										getLocalizedMessage("gui-punish-targetinfo-lore",
												locale,
												this.target.getName(),
												this.target.getUUID().toString(),
												this.target.getRank().getName())
						).
						mergeSkull(this.target.getUUID()).
						build()
				, 1);

		this.setItem(
				new ItemBuilder(Material.STAINED_GLASS_PANE, 1).
						setName("").
						build()
				, 10
		);

		this.setItem(
				new ItemBuilder(Material.ARROW, 1).
						setName(LocalizedUtil.getLocalizedMessage("gui-global-return-displayname", locale)).
						setDescription(LocalizedUtil.getLocalizedMessage("gui-global-return-lore", locale)).
						setListener(new Return()).
						build()
				, 36
		);

	}

	@Override
	public OnigoriScreen getPreviousScreen() {
		return this.previousScreen;
	}

}

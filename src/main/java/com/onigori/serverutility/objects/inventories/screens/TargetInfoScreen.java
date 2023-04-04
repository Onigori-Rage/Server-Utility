package com.onigori.serverutility.objects.inventories.screens;

import com.onigori.api.guihelper.ItemBuilder;
import com.onigori.api.guihelper.components.OnigoriScreen;
import com.onigori.api.guihelper.components.ReturnableScreen;
import com.onigori.serverutility.modules.LocalizedMessage;
import com.onigori.serverutility.objects.inventories.handlers.TargetInfo;
import com.onigori.serverutility.players.SUtilPlayer;
import org.bukkit.Material;

import java.util.Locale;

public class TargetInfoScreen extends OnigoriScreen implements ReturnableScreen {

	private final SUtilPlayer target;

	private final Locale locale;

	private final OnigoriScreen previousScreen;

	public TargetInfoScreen(SUtilPlayer target, Locale locale, OnigoriScreen previousScreen) {
		super(5, LocalizedMessage.getLocalizedMessage("gui-targetinfo-displayname", locale));

		this.target = target;

		this.locale = locale;
		this.previousScreen = previousScreen;

		this.init();
	}

	@Override
	public void init() {
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
												this.target.getPermission().name())
						).
						mergeSkull(this.target.getUUID()).
						build()
				, 22);

	}

	@Override
	public OnigoriScreen getPreviousScreen() {
		return this.previousScreen;
	}

}

package com.onigori.serverutility.objects.inventories;

import com.onigori.api.guihelper.ItemBuilder;
import com.onigori.api.guihelper.components.ItemHandler;
import com.onigori.api.guihelper.components.OnigoriScreen;
import com.onigori.serverutility.modules.LocalizedMessage;
import com.onigori.serverutility.objects.inventories.handlers.Cancel;
import com.onigori.serverutility.objects.inventories.handlers.punish.TargetInfo;
import com.onigori.serverutility.objects.punishments.Ban;
import com.onigori.serverutility.players.SUtilPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;

public class PunishScreen extends OnigoriScreen {

	private final SUtilPlayer executor;

	private final SUtilPlayer target;

	public PunishScreen(SUtilPlayer executor, SUtilPlayer target) {
		super(5, LocalizedMessage.getLocalizedMessage("gui-punish-displayname", executor.getLocale()));

		this.executor = executor;
		this.target = target;

		this.init();
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
				, 0, 8, 36, 44
		);

		//Ban

		this.setItem(
				new ItemBuilder(Material.LAVA_BUCKET, 1).
						setName(LocalizedMessage.getLocalizedMessage("gui-punish-banaction-displayname", this.executor.getLocale())).
						setDescription(LocalizedMessage.getLocalizedMessage("gui-punish-banaction-lore", this.executor.getLocale())).
						build()
				, 19
		);

		//Mute

		this.setItem(
				new ItemBuilder(Material.REDSTONE_BLOCK, 1).
						setName(LocalizedMessage.getLocalizedMessage("gui-punish-muteaction-displayname", this.executor.getLocale())).
						setDescription(LocalizedMessage.getLocalizedMessage("gui-punish-muteaction-lore", this.executor.getLocale())).
						build()
				, 25
		);

		//Kick

		this.setItem(
				new ItemBuilder(Material.DISPENSER, 1).
						setName(LocalizedMessage.getLocalizedMessage("gui-punish-kickaction-displayname", this.executor.getLocale())).
						setDescription(LocalizedMessage.getLocalizedMessage("gui-punish-kickaction-lore", this.executor.getLocale())).
						build()
				, 4
		);

		//Warn

		this.setItem(
				new ItemBuilder(Material.REDSTONE_TORCH_ON, 1).
						setName(LocalizedMessage.getLocalizedMessage("gui-punish-warnaction-displayname", this.executor.getLocale())).
						setDescription(LocalizedMessage.getLocalizedMessage("gui-punish-warnaction-lore", this.executor.getLocale())).
						build()
				, 40
		);

	}

}

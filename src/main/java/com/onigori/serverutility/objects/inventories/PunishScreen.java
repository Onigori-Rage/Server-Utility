package com.onigori.serverutility.objects.inventories;

import com.onigori.api.guihelper.ItemBuilder;
import com.onigori.api.guihelper.components.ItemHandler;
import com.onigori.api.guihelper.components.OnigoriScreen;
import com.onigori.serverutility.modules.LocalizedMessage;
import com.onigori.serverutility.objects.inventories.handlers.punish.TargetInfo;
import com.onigori.serverutility.objects.punishments.Ban;
import com.onigori.serverutility.players.SUtilPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class PunishScreen extends OnigoriScreen {

	private final SUtilPlayer executor;

	private final SUtilPlayer target;

	static {
		ConcurrentHashMap<Integer, ItemHandler> handler = new ConcurrentHashMap<>();
		handler.put(22, new TargetInfo());
		OnigoriScreen.addHandler(PunishScreen.class.getName(), handler);
	}

	public PunishScreen(SUtilPlayer executor, SUtilPlayer target) {
		super(5, LocalizedMessage.getLocalizedMessage("gui-punish-displayname", executor.getLocale()));

		this.executor = executor;
		this.target = target;

		this.init();
	}

	@Override
	public void init() {
		// Target Info
		this.getInventory().
				setItem(22, new ItemBuilder(Material.SKULL_ITEM, 1).
				setName(LocalizedMessage.getLocalizedMessage("gui-punish-targetinfo-displayname", this.executor.getLocale())).
				setDescription(
						LocalizedMessage.
								getLocalizedMessage("gui-punish-targetinfo-lore",
										this.executor.getLocale(),
										this.target.getName(),
										this.target.getUUID().toString(),
										this.target.getPermission().name())
								.split("\n")
				).
				mergeSkull(this.target.getUUID()).
				build()
		);

		// Close





	}

}

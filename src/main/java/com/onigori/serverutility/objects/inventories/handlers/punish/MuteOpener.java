package com.onigori.serverutility.objects.inventories.handlers.punish;

import com.onigori.api.guihelper.GUIHelper;
import com.onigori.api.guihelper.components.ItemHandler;
import com.onigori.api.guihelper.components.OnigoriScreen;
import com.onigori.serverutility.players.SUtilPlayer;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.event.inventory.ClickType;

public class MuteOpener implements ItemHandler {

	@Override
	public void execute(SUtilPlayer player, OnigoriScreen screen, ClickType type) {
		player.sendTranslated(ChatColor.GREEN + "Coming soon...", true);

		GUIHelper.closeInventory(player.getCore());
	}
}

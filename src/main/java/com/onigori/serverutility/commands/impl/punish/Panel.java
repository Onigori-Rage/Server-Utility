package com.onigori.serverutility.commands.impl.punish;

import com.onigori.api.guihelper.GUIHelper;
import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.Symbols;
import com.onigori.serverutility.commands.Command;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.commands.SubCommand;
import com.onigori.serverutility.modules.ArgumentManager;
import com.onigori.serverutility.objects.inventories.screens.PunishScreen;
import com.onigori.serverutility.objects.inventories.screens.punish.ScreenType;
import com.onigori.serverutility.players.SUtilPlayer;
import org.bukkit.entity.Player;

public class Panel implements SubCommand {

	@Override
	public void execute(Sender sender, String[] args, Command instance) {
		if (sender.isPlayer()) {
			SUtilPlayer executor = (SUtilPlayer) sender;
			Player coreExecutor = executor.getCore();

			SUtilPlayer target = SUtilMain.getPlayerFactory().fetch(args[1]);

			String reason = args.length >= 3 ? ArgumentManager.getArgumentsByArray(args, 2, " ") : Symbols.DEFAULT_REASON;

			GUIHelper.openInventory(new PunishScreen(executor, target, reason, ScreenType.BOSS, null), coreExecutor);

			return;
		}

		sender.sendMessage("command-spunish-panel-executor-error", true);
	}

}

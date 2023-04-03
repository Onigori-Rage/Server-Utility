package com.onigori.serverutility.commands.impl.punish;

import com.onigori.api.guihelper.GUIHelper;
import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.commands.Command;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.commands.SubCommand;
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

			String reason = args.length >= 3 ? getArgumentsByArray(args, 2, " ") : "Undefined.";

			GUIHelper.openInventory(new PunishScreen(executor, target, reason, ScreenType.BOSS), coreExecutor);

			return;
		}

		sender.sendMessage("command-spunish-panel-executor-error", true);
	}

	public static String getArgumentsByArray(String[] args, int startIndex, String suffix) {
		StringBuilder stringBuilder = new StringBuilder();

		for (int index = startIndex; index <= (args.length - 1); index = index + 1) {
			stringBuilder.append(args[index] + suffix);
		}

		stringBuilder.setLength(stringBuilder.length() - suffix.length());
		return stringBuilder.toString();
	}

}

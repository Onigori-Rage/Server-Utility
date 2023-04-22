package com.onigori.serverutility.commands.impl.help;

import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.commands.SubCommand;
import com.onigori.serverutility.modules.LocalizedMessage;
import net.md_5.bungee.api.ChatColor;

public class Command implements SubCommand {

	@Override
	public void execute(Sender sender, String[] args, com.onigori.serverutility.commands.Command instance) {
		if (args.length >= 2) {
			com.onigori.serverutility.commands.Command command = SUtilMain.getCommandHandler().getCommand(args[1]);
			if (command != null) {
				String usage = LocalizedMessage.getLocalizedMessage(command.getUsageKey(), sender.getLocale())
						.replaceAll("§cCorrect usage: ", "")
						.replaceAll("§c使い方: ", "");
				usage = ChatColor.stripColor(usage);

				String description = "Undefined.";//LocalizedMessage.getLocalizedMessage(command.getDescriptionKey(), sender.getLocale());

				sender.sendMessage("command-help-command-success", true, command.getName(), description, String.valueOf(command.getRequiredValue()), usage);
				return;
			}

			sender.sendMessage("command-help-command-failed", true);
			return;
		}
		sender.sendMessage(instance.getUsageKey(), true);
	}

}

package com.onigori.serverutility.commands.impl.help;

import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.commands.Command;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.commands.SubCommand;
import net.md_5.bungee.api.ChatColor;

public class List implements SubCommand {

	@Override
	public void execute(Sender sender, String[] args, Command instance) {
		final StringBuilder stringBuilder = new StringBuilder();

		for (Command command : SUtilMain.getCommandHandler().getCommands()) {
			if (sender.getRank().getValue() >= command.getRequiredValue()) {
				stringBuilder.append(command.getName());

				if (command.isAddonCommand()) {
					stringBuilder.append(ChatColor.GREEN + "*" + ChatColor.WHITE);
				}

				stringBuilder.append(", ");
			}
		}

		stringBuilder.setLength(stringBuilder.length() - 2);

		final String availableCommandsList = stringBuilder.toString();

		sender.sendMessage("command-help-list-success", true, availableCommandsList);
	}

}

package com.onigori.serverutility.commands.impl.help;

import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.commands.Command;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.commands.SubCommand;
import com.onigori.serverutility.objects.Permission;

public class List implements SubCommand {

	@Override
	public void execute(Sender sender, String[] args, Command instance) {
		StringBuilder stringBuilder = new StringBuilder();

		for (Command command : SUtilMain.getCommandHandler().getCommands()) {
			if (Permission.comparedPermission(sender, command.getPermission())) {
				stringBuilder.append(command.getName() + ", ");
			}
		}
		stringBuilder.setLength(stringBuilder.length() - 2);

		String availableCommandsList = stringBuilder.toString();

		sender.sendMessage("command-shelp-list-success", true, availableCommandsList);
	}

}

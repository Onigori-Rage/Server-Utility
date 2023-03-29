package com.onigori.serverutility.commands;

import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.commands.impl.DefaultCommand;
import com.onigori.serverutility.modules.LocalizedMessage;
import com.onigori.serverutility.objects.IInit;
import com.onigori.serverutility.objects.Permission;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.concurrent.ConcurrentHashMap;

public class CommandHandler implements IInit {

	private final ConcurrentHashMap<String, AbstractCommand> commandMap = new ConcurrentHashMap<>();

	private final AbstractCommand defaultCommand = new DefaultCommand();

	@Override
	public void init() {
	}

	@Override
	public void stop() {

	}

	/*
	Logic (dispatching command)
	 */
	public void dispatchCommand(CommandSender sender, String[] args, String command) {
		AbstractCommand commandExecutor = commandMap.getOrDefault(command, this.defaultCommand);

		if (sender instanceof ConsoleCommandSender) {
			commandExecutor.execute(sender, args);
			return;
		}

		Player player = (Player) sender;
		if (Permission.comparedPermission(sender, commandExecutor.getPermission())) {
			commandExecutor.execute(sender, args);
		}
		else {
			// Send permission message:
		}
	}

}

package com.onigori.serverutility.commands;

import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.commands.impl.DefaultCommand;
import com.onigori.serverutility.objects.IInit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

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

	public void dispatchCommand(CommandSender sender, String[] args, String command) {
		AbstractCommand commandExecutor = commandMap.getOrDefault(command, this.defaultCommand);

		if (sender instanceof ConsoleCommandSender) {
			commandExecutor.execute(sender, args);
		}

		else {
			if ()
		}
	}

}

package com.onigori.serverutility.commands;

import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.commands.impl.Default;
import com.onigori.serverutility.commands.impl.Help;
import com.onigori.serverutility.commands.impl.Lang;
import com.onigori.serverutility.commands.impl.Punish;
import com.onigori.serverutility.objects.Permission;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

public class CommandHandler {

	private final ConcurrentHashMap<String, Command> commandMap = new ConcurrentHashMap<>();

	private final Command defaultCommand = new Default();

	public void init() {
		this.addCommand(new Punish());
		this.addCommand(new Lang());
		this.addCommand(new Help());
	}

	public void stop() {

	}

	private void addCommand(Command command) {
		this.commandMap.put(command.getName(), command);
	}

	public Collection<Command> getCommands() {
		return this.commandMap.values();
	}

	public Command getCommandOrDefault(String command) {
		return this.commandMap.getOrDefault(command, this.defaultCommand);
	}

	public Command getCommand(String command) {
		return this.commandMap.get(command);
	}

	/*
	Logic (dispatching command)
	 */
	public void dispatchCommand(CommandSender commandSender, String[] args, String command) {
		long a = System.nanoTime();
		Command commandExecutor = this.getCommandOrDefault(command);

		final Sender sender = commandSender instanceof ConsoleCommandSender ? SUtilMain.getSender() : SUtilMain.getPlayerFactory().fetch(((Player) commandSender).getUniqueId());

		if (Permission.comparedPermission(sender, commandExecutor.getPermission())) {
			commandExecutor.execute(sender, args);
		}
		else {
			sender.sendMessage("command-permission-error", true);
		}
		long b = System.nanoTime();
		System.out.println(b-a);
	}

}

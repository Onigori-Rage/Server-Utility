package com.onigori.serverutility.commands;

import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.commands.impl.*;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

public class CommandHandler {

	private final ConcurrentHashMap<String, Command> commandMap = new ConcurrentHashMap<>();

	private final Command defaultCommand = new Default();

	public void init() {
		addCommand(new Punish());
		addCommand(new Lang());
		addCommand(new Help());

		addCommand(new Search());
		addCommand(new Rank());

		addCommand(new UserInfo());
	}

	public void stop() {

	}

	public void addCommand(Command command) {
		this.commandMap.put(command.getName(), command);
	}

	public Collection<Command> getCommands() {
		return this.commandMap.values();
	}

	public final Command getCommandOrDefault(final String command) {
		return this.commandMap.getOrDefault(command, this.defaultCommand);
	}

	public final Command getCommand(final String command) {
		return this.commandMap.get(command);
	}

	/*
	Logic (dispatching command)
	 */
	public final void dispatchCommand(final CommandSender commandSender, final String[] args, final String command) {

		Bukkit.getScheduler().runTaskAsynchronously(SUtilMain.getInstance(),
				() -> this.dispatchCommand(commandSender instanceof ConsoleCommandSender ? SUtilMain.getSender() : SUtilMain.getPlayerFactory().fetch(((Player) commandSender).getUniqueId()), args, command)
		);

	}

	public final void dispatchCommand(final Sender sender, final String[] args, final String command) {
		final Command commandExecutor = this.getCommandOrDefault(command);

		if (sender.getRank().getValue() >= commandExecutor.getRequiredValue()) {
			commandExecutor.execute(sender, args);

			return;
		}

		sender.sendMessage("command-permission-error", true);
	}

}

package com.onigori.serverutility.commands;

import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.commands.impl.Default;
import com.onigori.serverutility.commands.impl.SPunish;
import com.onigori.serverutility.objects.IInit;
import com.onigori.serverutility.objects.Permission;
import com.onigori.serverutility.players.SUtilPlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.concurrent.ConcurrentHashMap;

public class CommandHandler implements IInit {

	private final ConcurrentHashMap<String, AbstractCommand> commandMap = new ConcurrentHashMap<>();

	private final AbstractCommand defaultCommand = new Default();

	@Override
	public void init() {
		this.addCommand(new SPunish());
	}

	@Override
	public void stop() {

	}

	private void addCommand(AbstractCommand command) {
		commandMap.put(command.getName(), command);
	}

	/*
	Logic (dispatching command)
	 */
	public void dispatchCommand(CommandSender commandSender, String[] args, String command) {
		long a = System.nanoTime();
		AbstractCommand commandExecutor = commandMap.getOrDefault(command, this.defaultCommand);

		final Sender sender;

		if (commandSender instanceof ConsoleCommandSender) {
			sender = SUtilMain.getSender();
		}
		else {
			Player player = (Player) commandSender;
			sender = SUtilMain.getPlayerFactory().fetch(player.getUniqueId());
		}

		if (Permission.comparedPermission(sender, commandExecutor.getPermission())) {
			commandExecutor.execute(sender, args);
		}
		else {
			sender.sendMessage("permission-error");
		}
		long b = System.nanoTime();
		System.out.println(b-a);
	}

}

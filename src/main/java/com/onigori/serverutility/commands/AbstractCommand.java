package com.onigori.serverutility.commands;

import org.bukkit.command.CommandSender;

public abstract class AbstractCommand {

	public abstract void execute(CommandSender sender, String[] args);

}

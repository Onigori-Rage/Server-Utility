package com.onigori.serverutility.commands.impl.help;

import com.onigori.serverutility.Symbols;
import com.onigori.serverutility.commands.Command;
import com.onigori.serverutility.commands.Sender;
import com.onigori.serverutility.commands.SubCommand;

public class Info implements SubCommand {

	@Override
	public void execute(Sender sender, String[] args, Command instance) {
		sender.sendMessage("welcome", true, Symbols.AUTHOR, Symbols.DISCORD, Symbols.VERSION);
	}

}

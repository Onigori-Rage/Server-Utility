package com.onigori.serverutility.commands;

public interface SubCommand {

	void execute(Sender sender, String[] args, Command instance);

}

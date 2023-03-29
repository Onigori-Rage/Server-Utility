package com.onigori.serverutility.commands;

import com.onigori.serverutility.commands.impl.DefaultCommand;
import com.onigori.serverutility.objects.IInit;

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

	public void dispatchCommand()

}

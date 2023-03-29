package com.onigori.serverutility.modules;

import com.onigori.serverutility.objects.IInit;
import com.onigori.serverutility.objects.Sender;
import com.onigori.serverutility.players.SUtilPlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class PlayerFactory implements IInit {

	private final ConcurrentHashMap<UUID, SUtilPlayer> playerMap = new ConcurrentHashMap<>();

	@Override
	public void init() {

	}

	@Override
	public void stop() {

	}

	public SUtilPlayer fetch(CommandSender sender) {

	}

	class SenderFactory implements IInit {

		private Sender console;

		@Override
		public void init() {
			console = new Sender();
		}

		@Override
		public void stop() {

		}

		public Sender fetch(CommandSender sender) {
			if (sender instanceof ConsoleCommandSender) {
				return console;
			}
			return null;
		}

	}


}

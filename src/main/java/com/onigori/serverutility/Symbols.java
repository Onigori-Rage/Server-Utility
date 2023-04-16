package com.onigori.serverutility;

import com.onigori.serverutility.objects.players.Rank;
import net.md_5.bungee.api.ChatColor;

import java.util.Locale;

public class Symbols {

	public static final String PREFIX = ChatColor.WHITE + "[" + ChatColor.YELLOW + "S" + ChatColor.AQUA + "Util" + ChatColor.WHITE + "] ";

	public static final String AUTHOR = "Onigori_Rage";

	public static final String VERSION = "0.7";

	public static final String NAME = "Server-Utility";

	public static final String DISCORD = "コオリヤマ・オニゴーリ#7949";

	public static final Locale DEFAULT_LOCALE = Locale.ENGLISH;

	public static final String DEFAULT_REASON = "Unknown / なし";

	public static final String CONSOLE_NAME = "CONSOLE";

	public static final Rank CONSOLE_RANK = new Rank("*", "", 100);

}

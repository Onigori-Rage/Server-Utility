package com.onigori.serverutility.modules;

import com.onigori.serverutility.SUtilMain;
import com.onigori.serverutility.Symbols;
import jdk.incubator.foreign.LibraryLookup;

public class SUtilLogger {

	public static final void printLog(String log) {
		SUtilMain.getConsole().sendMessage(Symbols.PREFIX + log);
	}

}

package com.abdul.useradmin.util;

public final class IDGenerator {
	private static int i;
	
	public static final int generateID() {
		return i++;
	}
}

package com.tca.util;

public class Counter {
	private static Integer count;
	
	static {
		count = 1;
	}
	
	public static synchronized Integer getCount() {
		return count++;
	}
	
}

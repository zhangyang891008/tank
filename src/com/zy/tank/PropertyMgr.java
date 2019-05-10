package com.zy.tank;

import java.io.IOException;
import java.util.Properties;

public class PropertyMgr {
	private static Properties props = new Properties();
	static {
		try {
			props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String get(String key) {
		return props.getProperty(key);
	}

}

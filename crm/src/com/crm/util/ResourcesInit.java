package com.crm.util;

import java.util.ResourceBundle;

public class ResourcesInit {
	private static ResourceBundle resourceBundle;
	static {
		resourceBundle = ResourceBundle.getBundle("ApplicationResources");
	}
	public static String getString(String key){
		return resourceBundle.getString(key);
	}
	

}

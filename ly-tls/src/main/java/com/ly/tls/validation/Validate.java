package com.ly.tls.validation;

import java.util.Map;

public class Validate {
	public static boolean matchs(Map<String,Object> paramMap,String name,String regex) {
		Object obj = paramMap.get(name);
		if(name != null && obj.toString().matches(regex)) {
			return true;
		}
		return false;
	}
	public static boolean matchs(String name,String regex) {
		return name.matches(regex);
	}
}

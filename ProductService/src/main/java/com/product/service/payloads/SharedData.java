package com.product.service.payloads;

import java.util.HashMap;
import java.util.Map;

public class SharedData {

	static Map<String, String> dataMap = new HashMap<>(); 
	static Map<String, String> blackListToken = new HashMap<>();
	
	public static  void setData(String key, String value) {
		dataMap.put(key, value);
	}
	
	public static Map<String, String> getSharedDataMap() {
		return dataMap;
	}
	
	public static  void setBlackListToken(String key, String value) {
		blackListToken.put(key, value);
	}
	
	public static Map<String, String> getBlackListToken() {
		return blackListToken;
	}
	
}

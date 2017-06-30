package com.framework.core.web;

import java.util.HashMap;
import java.util.Map;

public class LoginInfo {
	public static final String SESSION_KEY = "_loginInfo";

	public  Map<String,Object> infos = new HashMap<>();
	
	public LoginInfo(){
		
	}
	
	public LoginInfo(String key, Object value){
		this.addInfo(key, value);
	}
	
	public void addInfo(String key, Object value){
		this.infos.put(key, value);
	}
	
	public void removeInfo(String key){
		this.infos.remove(key);
	}
	
	public Map<String,Object> getInfos(){
		return this.infos;
	}
	
}

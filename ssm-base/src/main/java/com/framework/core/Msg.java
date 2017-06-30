package com.framework.core;

import java.util.HashMap;
import java.util.Map;

public class Msg {
	private int code;
	private String desc;
	
	private Map<String,Object> dataMap = new HashMap<String,Object>();

	public Msg(){
		
	}
	
	public Msg(int code, String desc){
		this.code = code;
		this.desc = desc;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public static Msg success(){
		return success("处理成功");
	}
	
	public static Msg success(String msg){
		return new Msg(1,msg);
	}
	
	public static Msg fail(){
		return fail("处理失败");
	}
	
	public static Msg fail(String msg){
		return new Msg(2,msg);
	}
	
	public Msg add(String key , Object value){
		this.dataMap.put(key, value);
		return this;
	}

}

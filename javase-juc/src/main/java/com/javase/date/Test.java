package com.javase.date;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Test {

	public static void main(String[] args) {
		BigDecimal bd = null;
		
		// TODO Auto-generated method stub
		String jsonStr="[{\"value\":2114.0,\"line\":\"sckc_sum\",\"ts\":1.4967144E12,\"desc\":\"1市场空充总业务量\"},{\"value\":2089.0,\"line\":\"sckc_suc\",\"ts\":1.4967144E12,\"desc\":\"2市场空充成功业务量\"},{\"value\":25.0,\"line\":\"sckc_fail\",\"ts\":1.4967144E12,\"desc\":\"3市场空充失败业务量\"},{\"value\":100.0,\"line\":\"sckc_syssuc\",\"ts\":1.4967144E12,\"desc\":\"4系统成功率\"}]";
		
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(jsonStr);
		
		JsonArray ja = null;
		if(je.isJsonArray()){
			ja = je.getAsJsonArray();
		}
		
		
		Iterator<JsonElement> it = ja.iterator();
		while(it.hasNext()){
			JsonElement e = it.next();
			System.out.println(e);
			
			JsonObject o = e.getAsJsonObject();
			JsonElement value = o.get("ts");
			bd = value.getAsBigDecimal();
			
			//BigDecimal bd = new BigDecimal("1.4967144E12");
			System.out.println("毫秒数："+bd.longValue());
			
			Date date = new Date();
			date.setTime(bd.longValue());
			
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
			System.out.println("转换后的时间："+format.format(date));
		}
	}

}

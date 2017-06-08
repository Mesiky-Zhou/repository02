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
		String jsonStr="[{\"value\":2114.0,\"line\":\"sckc_sum\",\"ts\":1.4967144E12,\"desc\":\"1�г��ճ���ҵ����\"},{\"value\":2089.0,\"line\":\"sckc_suc\",\"ts\":1.4967144E12,\"desc\":\"2�г��ճ�ɹ�ҵ����\"},{\"value\":25.0,\"line\":\"sckc_fail\",\"ts\":1.4967144E12,\"desc\":\"3�г��ճ�ʧ��ҵ����\"},{\"value\":100.0,\"line\":\"sckc_syssuc\",\"ts\":1.4967144E12,\"desc\":\"4ϵͳ�ɹ���\"}]";
		
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
			System.out.println("��������"+bd.longValue());
			
			Date date = new Date();
			date.setTime(bd.longValue());
			
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
			System.out.println("ת�����ʱ�䣺"+format.format(date));
		}
	}

}

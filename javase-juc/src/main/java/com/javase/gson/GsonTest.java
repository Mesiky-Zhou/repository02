package com.javase.gson;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GsonTest {

	public static void main(String[] args) {
		String jsonStr="[{\"value\":2114.0,\"line\":\"sckc_sum\",\"ts\":1.4967144E12,\"desc\":\"1�г��ճ���ҵ����\"},{\"value\":2089.0,\"line\":\"sckc_suc\",\"ts\":1.4967144E12,\"desc\":\"2�г��ճ�ɹ�ҵ����\"},{\"value\":25.0,\"line\":\"sckc_fail\",\"ts\":1.4967144E12,\"desc\":\"3�г��ճ�ʧ��ҵ����\"},{\"value\":100.0,\"line\":\"sckc_syssuc\",\"ts\":1.4967144E12,\"desc\":\"4ϵͳ�ɹ���\"}]";
		List<Map<String,String>> list= jsonStringToList(jsonStr);
		
		for(Map<String,String> map : list){
			System.out.println(map);
		}
		

	}
	
	public static List<Map<String,String>> jsonStringToList(String jsonString){
		Gson gson = new Gson();
		List<Map<String,String>> list= gson.fromJson(jsonString,
				new TypeToken<List<Map<String,String>>>(){}.getType());
		
		return list;
	}

}

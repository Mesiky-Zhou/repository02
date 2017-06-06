package com.javase.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateService {
	
	public static String mins[];
	public static SimpleDateFormat format = new SimpleDateFormat("yyyMMddHH");
	public static SimpleDateFormat format2 = new SimpleDateFormat("yyyMMddHHmmss");
	static{
		initMins();
	}
	
	private static void initMins(){
		mins = new String[12];
		for(int i=0;i<12*5;i=i+5){
			String temp = "";
			if(i<10){
				temp = "0" + i + "00";
			}else{
				temp = i + "00";
			}
			
			mins[i/5]=temp;
		}
	}
	
	public String getEndDatetime(Date date){
		String result = "";
		String tempArr[] = new String[mins.length+1];
		
		String nowDateStr = format.format(date);
		
		/*Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.HOUR_OF_DAY, -1);
		Date preHour = c.getTime();
		String preDataStr = format.format(preHour);
		
		tempArr[0] = preDataStr + "5500";*/
		for(int i=0;i<mins.length;i++){
			tempArr[i] = nowDateStr + mins[i];
		}
		
		String nowDatetimeStr = format2.format(date);
		int index =0;
		
		for(int i=0;i<tempArr.length;i++){
			if( nowDatetimeStr.compareTo(tempArr[i])>0 ){
				index = i;
				continue;
			}else{
				break;
			}
		}
		
		result = tempArr[index];
		
		return result;
	}

	public static void main(String[] args) {
		DateService service = new DateService();
		String result = service.getEndDatetime(new Date());
		System.out.println(result);

	}

}

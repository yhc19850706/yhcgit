package com.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SimpleDateFormatTest {
	public static void main(String[] args) {
		try {
			Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.parse("2015-03-16 00:00:00");
			System.out.println("字符串类型转换为日期类型：" + date.toString());

			String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.format(date);

			System.out.println("日期类型转换为字符串类型：" + dateStr);
			
			String str = "Sat Oct 10 00:00:00 CST 2009";
	        SimpleDateFormat sdf =  new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy",Locale.US);
	        Date date1 = sdf.parse(str);
	        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        System.out.println(sdf.format(date1));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}

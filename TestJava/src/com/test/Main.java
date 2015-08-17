package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Properties property=new Properties();
//		try {
//            File file = new File("db.properties");
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//            // 写入
//            property.setProperty("database", "localhost1");
//            property.setProperty("user", "javaniubi");
//            property.setProperty("password", "password2");
//            property.store(new FileOutputStream(file), null);
//            property.load(new FileInputStream(file));
// 
//            // 读取
//            System.out.println(property.getProperty("database"));
//            System.out.println(property.getProperty("user"));
//            System.out.println(property.getProperty("password"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
		
		System.out.println(getMonth(0));
		System.out.println(getMonth(1));
		System.out.println(getMonth(2));
		System.out.println(getFirstDayOfMonth(new Date()));
	}

	/**
	 * 获得N天前的日期 格式 yyyyMMdd
	 * @return
	 */
	public static String getday(int day) {
		 Calendar   cal   =   Calendar.getInstance();
		  cal.add(Calendar.DATE,   -day);
		  return  new SimpleDateFormat( "yyyyMMdd").format(cal.getTime());
	}
	
	/**
	 * 获得N天前的月份 格式 yyyyMM
	 * @return
	 */
	public static String getMonth(int day) {
		 Calendar   cal   =   Calendar.getInstance();
		  cal.add(Calendar.MONTH,   -day);
		  return  new SimpleDateFormat( "yyyyMM").format(cal.getTime());
	}
	/**
     * 返回指定日期的月的第一天
     *
     * @param year
     * @param month
     * @return
     */
    public static String getFirstDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR),
                     calendar.get(Calendar.MONTH), 1);
        return new SimpleDateFormat( "yyyyMMdd").format(calendar.getTime());
    }
    /**
     * 返回指定日期的月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static String getLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR),
                     calendar.get(Calendar.MONTH), 1);
        calendar.roll(Calendar.DATE, -1);
        return new SimpleDateFormat( "yyyyMMdd").format(calendar.getTime());
    }
}

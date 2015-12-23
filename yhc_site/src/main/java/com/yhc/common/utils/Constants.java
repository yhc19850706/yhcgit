package com.yhc.common.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Constants {
	
	
	public static final String ALTMSG = "altMsg";
	public static final String RESULT = "result";
	public static final String SUCCESS = "success";
	public static final String FAIL = "fail";
	
	public static String YINHU = "yinhu";
	
	public static int COOKIE_MAX_TIME_TEN_MIN = 60 * 10;
	public static int COOKIE_MAX_TIME_HALF_HOUR = 60 * 30;
	public static int COOKIE_MAX_TIME_ONE_HOUR = 60 * 60;
	public static int COOKIE_MAX_TIME_ONE_DAY = 60 * 60 * 24;
	public static int COOKIE_MAX_TIME_ONE_WEEK = 60 * 60 * 24 * 7;
	
	public static final String COOKIE_YHC_UID = "_yhcbluid";
	public static final String COOKIE_YHC_TIME = "_yhcbltm";
	public static final String COOKIE_YHC_UNM = "_yhcblunm";
	public static final String COOKIE_YHC_REUNM = "_yhcblreunm";
	public static final String COOKIE_YHC_AUTH = "_yhcblreunm";
	
	public static String RM_DEPT_TYPE_CS = "CS";
	public static String RM_DEPT_TYPE_ZS = "ZS";
	
	//加密盐值
	public static String SALT="Yzdtyjm159753Hwdcnko456258C";
	
	public static String STATISTICS_TIME_TODAY = "today";
	public static String STATISTICS_TIME_ONE_WEEK = "oneweek";
	public static String STATISTICS_TIME_TWO_WEEK = "twoweek";
	public static String STATISTICS_TIME_ONE_MONTH = "onemonth";
	//最高学历 parent_id
	public static String EDUBG = "EDUBG";
	//婚姻状况
	public static String MERGST = "MERGST";
	//月收入
	public static String MONTHINCOME = "MONTHINCOME";
	//公司规模
	public static String CORPSCALE = "CORPSCALE";
	//公司行业
	public static String CORPCATEGORY = "CORPCATEGORY";
	//公司类型
	public static String CORPPROPERTY = "CORPPROPERTY";
	//工作年限
	public static String CORPWRKPRD = "CORPWRKPRD";

	

	public static HashMap<String, String> CONTENT_TYPE_MAP = new HashMap<String, String>();

	public static final ArrayList<String> IMG_CONTENT_TYPE_LIST = new ArrayList<String>();
	//中国电话号三位数字开头的城市的号码
	public final static List<String> THREE_BGIN_LIST = new ArrayList<String>();
	static {
		CONTENT_TYPE_MAP.put(".gif","image/gif" );
		CONTENT_TYPE_MAP.put(".jpeg","image/jpeg" );
		CONTENT_TYPE_MAP.put(".jpg","application/x-jpg" );
		CONTENT_TYPE_MAP.put(".png","application/x-png" );
		
		IMG_CONTENT_TYPE_LIST.add(".gif");
		IMG_CONTENT_TYPE_LIST.add(".jpg");
		IMG_CONTENT_TYPE_LIST.add(".png");
		IMG_CONTENT_TYPE_LIST.add(".jpeg");
		IMG_CONTENT_TYPE_LIST.add(".tiff");
		IMG_CONTENT_TYPE_LIST.add(".tif");
		
		
		THREE_BGIN_LIST.add("010"); //北京市
		THREE_BGIN_LIST.add("020"); //广州市
		THREE_BGIN_LIST.add("021"); //上海市
		THREE_BGIN_LIST.add("022"); //天津市
		THREE_BGIN_LIST.add("023"); //重庆市 
		THREE_BGIN_LIST.add("024"); //沈阳市
		THREE_BGIN_LIST.add("025"); //南京市
		THREE_BGIN_LIST.add("027"); //武汉市
		THREE_BGIN_LIST.add("028"); //成都市
		THREE_BGIN_LIST.add("029"); //西安市
	}


}

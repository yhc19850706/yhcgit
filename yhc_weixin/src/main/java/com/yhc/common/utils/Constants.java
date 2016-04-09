package com.yhc.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;

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
	
	public static final String COOKIE_BL_UID = "_xmphbluid";
	public static final String COOKIE_BL_TIME = "_xmphbltm";
	public static final String COOKIE_BL_UNM = "_xmphblunm";
	public static final String COOKIE_BL_REUNM = "_xmphblreunm";
	public static final String COOKIE_BL_AUTH = "_xmphblauthid";

	
	public static String STATISTICS_TIME_TODAY = "today";
	public static String STATISTICS_TIME_ONE_WEEK = "oneweek";
	public static String STATISTICS_TIME_TWO_WEEK = "twoweek";
	public static String STATISTICS_TIME_ONE_MONTH = "onemonth";
	
	
	//区域编码
	public static String AREACODE = "XMPHCODE";
	public static HashMap<String, String> CONTENT_TYPE_MAP = new HashMap<String, String>();

	public static final ArrayList<String> IMG_CONTENT_TYPE_LIST = new ArrayList<String>();
	//中国电话号三位数字开头的城市的号码
	public final static List<String> THREE_BGIN_LIST = new ArrayList<String>();
	public static final Map<String, String> WEIXIN_TEMPLATE_ID_MAP = Maps.newHashMap();
	
	public static final String RESPCODE_BINDSUCC = "101";//绑定成功
	public static final String RESPCODE_ALREADYBIND = "102";//已经绑定
	public static final String RESPCODE_BINDFAIL = "104";//绑定失败
	
	public static final String RESPCODE_SIGNSUCC = "201";//签到成功
	public static final String RESPCODE_ALREADYSIGN = "202";//已经签到
	public static final String RESPCODE_SIGNFAIL = "204";//签到失败
	
	public static final String RESPCODE_FAIL = "4";//查询失败
	
    public static final String EVENT_SUB="subscribe";
	
	public static final String EVENT_UNSUB="unsubscribe";
	
	public static final String EVENT_CURTAIN_TYPE="curtain";//窗帘类型
	
	public static final String EVENT_PREVIEW="preview";//收益查询
	
	public static final String EVENT_ACCOUNT="account";//账户信息
	
	public static final String EVENT_NEW_PRODUCT_NOTICE="notice";//新产品通知
	
	public static final String EVENT_PLATINFO="announcement";//平台简介
	
	public static final String EVENT_BACKGROUND="background";//股东背景
	
	public static final String EVENT_CONTACT="contact";//联系我们
	
	public static final String EVENT_TEMPLATE="TEMPLATESENDJOBFINISH";//联系我们
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

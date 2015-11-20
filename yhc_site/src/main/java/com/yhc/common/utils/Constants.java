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
	
	public static final String COOKIE_BL_UID = "_xmphbluid";
	public static final String COOKIE_BL_TIME = "_xmphbltm";
	public static final String COOKIE_BL_UNM = "_xmphblunm";
	public static final String COOKIE_BL_REUNM = "_xmphblreunm";
	public static final String COOKIE_BL_AUTH = "_xmphblauthid";
	
	public static String RM_DEPT_TYPE_CS = "CS";
	public static String RM_DEPT_TYPE_ZS = "ZS";
	
	public static String LOAN_LOG_TYPE_CJ = "创件时间";
	public static String LOAN_LOG_TYPE_JJ = "进件时间";
	public static String LOAN_LOG_TYPE_CP = "初审派单时间";
	public static String LOAN_LOG_TYPE_CT = "初审提交时间";
	public static String LOAN_LOG_TYPE_ZP = "终审派单时间";
	public static String LOAN_LOG_TYPE_ZT = "终审提交时间";
	public static String LOAN_LOG_TYPE_DY = "打印合同时间";
	public static String LOAN_LOG_TYPE_QY = "签约时间";
	public static String LOAN_LOG_TYPE_FK = "放款时间";
	public static String LOAN_LOG_TYPE_JD = "拒贷申请时间";
	public static String LOAN_LOG_TYPE_JS = "拒贷生效时间";
	
	public static String SALT="Yzdtyjm159753Hwdcnko456258C";
	//还款时间
	public static String OFF2OFF_REPAY_TIME = "18";
	public static String OFF2ON_REPAY_TIME = "18";//推到线上的标的还款时间 有可能 和 线下还款时间不同
	//逾期费率
	public static BigDecimal  OVERDUE_RATE = new BigDecimal(0.05);
	//借款类型
	public static String LOAN_TYPE_OFF2OFF = "CONTRACTTP01";//CONTRACTTP01[线下合同]//off2off
	public static String LOAN_TYPE_OFF2ON = "CONTRACTTP02";//CONTRACTTP02[线下转线上合同]//off2on
	
	public static String REWARD_RATE_START_DATES = "20141111000000";//奖励年化率活动开始时间
	public static String REWARD_RATE_END_DATES = "20150216235959";//奖励年化率活动结束时间，截止到15年2月16号 
	public static BigDecimal REWARD_LOAN_RATE = new BigDecimal(2);//奖励的年化率
	
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
	//交易类型
	public static String TRDTP = "TRDTP";
	//公司类型
	public static String CORPPROPERTY = "CORPPROPERTY";
	//工作年限
	public static String CORPWRKPRD = "CORPWRKPRD";
	//借款状态
	public static String LOANSTATUS = "LNSTAT";
	
	//区域编码
	public static String AREACODE = "XMPHCODE";
	public static HashMap<String, String> CONTENT_TYPE_MAP = new HashMap<String, String>();
	//客服邮箱
	public static String KFMAIL="kefu@xmfin.com";
//	public static String KFMAIL="yinhc@yinhu.com";
	//用于添加借款申请页面的显示借款产品
	public static List<Integer> PROD_ID_IN_LIST = new ArrayList<Integer>();
	//烟花渠道产品list
	public static List<Integer> FC_PROD_ID_IN_LIST = new ArrayList<Integer>();
	public static final ArrayList<String> IMG_CONTENT_TYPE_LIST = new ArrayList<String>();
	public static HashMap<String, String> STORE_TYPE_MAP = new HashMap<String, String>();
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
		
		PROD_ID_IN_LIST.add(1);
		PROD_ID_IN_LIST.add(2);
		PROD_ID_IN_LIST.add(3);
		PROD_ID_IN_LIST.add(4);
		PROD_ID_IN_LIST.add(5);
		PROD_ID_IN_LIST.add(6);
		PROD_ID_IN_LIST.add(7);
		
		FC_PROD_ID_IN_LIST.add(13);
		
		STORE_TYPE_MAP.put("大区", "Q");
		STORE_TYPE_MAP.put("城市", "C");
		STORE_TYPE_MAP.put("片区", "P");
		STORE_TYPE_MAP.put("门店", "S");
	}


}

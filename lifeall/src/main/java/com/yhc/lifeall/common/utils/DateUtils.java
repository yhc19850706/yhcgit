package com.yhc.lifeall.common.utils;

import org.apache.commons.lang.StringUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class DateUtils {
	//private static Logger logger = (Logger) LogFactory.getLog( DateUtils.class );

	public DateUtils() {
	}

	/**
	 * 获取系统当前时间
	 * 
	 * @return
	 * @throws UtilDateException
	 */
	public static java.sql.Date getCurrentSqlDate() {
		try {
			Date utilNow = new Date();
			java.sql.Date sqlNow = new java.sql.Date( utilNow.getTime() );
			return sqlNow;
		} catch ( Exception e ) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 获取系统当前时间
	 *
	 * @return
	 * @throws UtilDateException
	 */
	public static Date parseDate( java.sql.Date sqlDate ) {
		try {
			Date utilNow = new Date( sqlDate.getTime() );
			return utilNow;
		} catch ( Exception e ) {
			e.printStackTrace();
			return null;
		}
	}

	public static Date getCurrentDate() {
		try {
			Date utilNow = new Date();
			return utilNow;
		} catch ( Exception e ) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 获取系统当前时间
	 *
	 * @return
	 * @throws UtilDateException
	 */
	public static Timestamp getCurrentSqlTimestamp() {
		try {
			Timestamp timestamp = new Timestamp( System.currentTimeMillis() );
			return timestamp;
		} catch ( Exception e ) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 获取系统当前时间，格式为1970110时开始的毫秒
	 *
	 * @return
	 * @throws UtilDateException
	 */
	public static long getCurrentMillisecond() {
		return System.currentTimeMillis();
	}

	/**
	 * 时间格式转换，将毫秒数转换为字符串型时间
	 *
	 * @param date
	 *            毫秒
	 * @param format
	 *            格式
	 * @return 字符串型时间
	 */
	public static String dateFormat( long date, String format ) {
		try {
			// date = subTimeZoneOffset(date);
			if ( ( format == null ) || ( format.equals( "" ) ) )
				return new SimpleDateFormat( "yyyyMMddHHmmss" ).format( new Date( date ) );
			else
				return new SimpleDateFormat( format ).format( new Date( date ) );
		} catch ( Exception e ) {
			return "";
		}
	}

	/**
	 * 时间格式转换，将字符串型时间转换为毫秒数 "yyyy-MM-dd HH:mm:ss" => "12345" 19 "yyyyMMddHHmmss"
	 * => "12345" 14 "yyyy-MM-dd" => "12345" 10 返回 0 是格式不
	 *
	 * @param dateStr
	 * @return
	 */
	public static long dateFormat( String dateStr ) {
		dateStr = dateStr.trim();
		if ( dateStr.length() == 19 ) {
			try {
				Calendar cal = Calendar.getInstance();
				cal.set( Integer.parseInt( dateStr.substring( 0, 4 ) ), Integer.parseInt( dateStr.substring( 5, 7 ) ) - 1, Integer.parseInt( dateStr.substring( 8, 10 ) ), Integer.parseInt( dateStr.substring( 11, 13 ) ),
						Integer.parseInt( dateStr.substring( 14, 16 ) ), Integer.parseInt( dateStr.substring( 17, 19 ) ) );
				cal.set( Calendar.MILLISECOND, 0 );
				return ( cal.getTime().getTime() );
			} catch ( Exception e ) {
				return 0;
			}

		} else if ( dateStr.length() == 14 ) {
			try {
				Calendar cal = Calendar.getInstance();
				cal.set( Integer.parseInt( dateStr.substring( 0, 4 ) ), Integer.parseInt( dateStr.substring( 4, 6 ) ) - 1, Integer.parseInt( dateStr.substring( 6, 8 ) ), Integer.parseInt( dateStr.substring( 8, 10 ) ),
						Integer.parseInt( dateStr.substring( 10, 12 ) ), Integer.parseInt( dateStr.substring( 12, 14 ) ) );
				cal.set( Calendar.MILLISECOND, 0 );
				return ( cal.getTime().getTime() );
			} catch ( Exception e ) {
				return 0;
			}
		} else if ( dateStr.length() == 10 ) {
			try {
				Calendar cal = Calendar.getInstance();
				cal.set( Integer.parseInt( dateStr.substring( 0, 4 ) ), Integer.parseInt( dateStr.substring( 5, 7 ) ) - 1, Integer.parseInt( dateStr.substring( 8, 10 ) ), 0, 0, 0 );
				cal.set( Calendar.MILLISECOND, 0 );
				return ( cal.getTime().getTime() );
			} catch ( Exception e ) {
				return 0;
			}
		} else {
			return 0;
		}

	}

	/**
	 * 时间格式转换，将字符串型时间转换为毫秒数 "yyyy-MM-dd HH:mm:ss" => "12345" 19 "yyyyMMddHHmmss"
	 * => "12345" 14 "yyyy-MM-dd" => "12345" 10 返回 0 是格式不
	 *
	 * @param dateStr
	 * @return
	 */
	public static long parseStringToLong( String dateStr ) {
		dateStr = dateStr.trim();
		if ( dateStr.length() == 19 ) {
			try {
				Calendar cal = Calendar.getInstance();
				cal.set( Integer.parseInt( dateStr.substring( 0, 4 ) ), Integer.parseInt( dateStr.substring( 5, 7 ) ) - 1, Integer.parseInt( dateStr.substring( 8, 10 ) ), Integer.parseInt( dateStr.substring( 11, 13 ) ),
						Integer.parseInt( dateStr.substring( 14, 16 ) ), Integer.parseInt( dateStr.substring( 17, 19 ) ) );
				cal.set( Calendar.MILLISECOND, 0 );
				return ( cal.getTime().getTime() );
			} catch ( Exception e ) {
				return 0;
			}

		} else if ( dateStr.length() == 14 ) {
			try {
				Calendar cal = Calendar.getInstance();
				cal.set( Integer.parseInt( dateStr.substring( 0, 4 ) ), Integer.parseInt( dateStr.substring( 4, 6 ) ) - 1, Integer.parseInt( dateStr.substring( 6, 8 ) ), Integer.parseInt( dateStr.substring( 8, 10 ) ),
						Integer.parseInt( dateStr.substring( 10, 12 ) ), Integer.parseInt( dateStr.substring( 12, 14 ) ) );
				cal.set( Calendar.MILLISECOND, 0 );
				return ( cal.getTime().getTime() );
			} catch ( Exception e ) {
				return 0;
			}
		} else if ( dateStr.length() == 10 ) {
			try {
				Calendar cal = Calendar.getInstance();
				cal.set( Integer.parseInt( dateStr.substring( 0, 4 ) ), Integer.parseInt( dateStr.substring( 5, 7 ) ) - 1, Integer.parseInt( dateStr.substring( 8, 10 ) ), 0, 0, 0 );
				cal.set( Calendar.MILLISECOND, 0 );
				return ( cal.getTime().getTime() );
			} catch ( Exception e ) {
				return 0;
			}
		} else {
			try {
				return Long.parseLong( dateStr );
			} catch ( Exception e ) {
				return 0;
			}

		}

	}

	/**
	 * 转换时间 long -> String
	 *
	 * @param timestamp
	 *            传入系统时间
	 * @return String
	 */
	public static String parseLongToString( long timestamp ) {
		SimpleDateFormat bartDateFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
		String aa = null;
		try {
			Date date = new Date( timestamp );
			aa = bartDateFormat.format( date );
		} catch ( Exception ex ) {
			//logger.error( ex.getMessage() );
		}
		return aa;
	}

	/**
	 * 转换时间 long -> String 时间格式：yyyy-MM-dd
	 *
	 * @param timestamp
	 *            传入系统时间
	 * @return String
	 */
	public static String parseLongToString1( long timestamp ) {
		SimpleDateFormat bartDateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
		String aa = null;
		try {
			Date date = new Date( timestamp );
			aa = bartDateFormat.format( date );
		} catch ( Exception ex ) {
			//logger.error( ex.getMessage() );
		}
		return aa;
	}

	public static Date getDate( String name, String df, Date defaultValue ) {
		if ( name == null ) {
			return defaultValue;
		}

		SimpleDateFormat formatter = new SimpleDateFormat( df );

		try {
			if ( name.length() < 11 ) {
				name += " 00:00:00";
			}
			if ( name.indexOf( "/" ) > -1 ) {
				name = StringUtils.replace( name, "/", "-" );
			}
			return formatter.parse( name );
		} catch ( ParseException e ) {

		}

		return defaultValue;
	}

	public static Date getDateDf( String name, String df ) {
		return getDate( name, df, null );
	}

	public static Date getDate( String name, String df ) {
		return getDate( name, df, null );
	}

	public static Date getDate( String name ) {
		return getDate( name, "yyyy-MM-dd", null );
	}

	public static Date getMonth( String name ) {
		return getDate( name, "yyyy-MM", null );
	}

	public static Date getDateTime( String name ) {
		return getDateTime( name, null );
	}

	public static Date getDate( String name, Date defaultValue ) {
		return getDate( name, "yyyy-MM-dd", defaultValue );
	}

	public static Date getDateTime( String name, Date defaultValue ) {
		return getDate( name, "yyyy-MM-dd HH:mm:ss", defaultValue );
	}

	/**
	 * 时间格式转换，将毫秒数转换为字符串型时间
	 *
	 * @param date
	 *            java.util.Date
	 * @param format
	 *            格式
	 * @return 字符串型时间
	 */
	public static String dateFormat( Date date, String format ) {
		try {
			// date = subTimeZoneOffset(date);
			if ( ( format == null ) || ( format.equals( "" ) ) )
				return new SimpleDateFormat( "yyyyMMddHHmmss" ).format( date );
			else
				return new SimpleDateFormat( format ).format( date );
		} catch ( Exception e ) {
			return "";
		}
	}

	public static Timestamp parseTimestamp( Date utilDate ) {
		try {
			Timestamp timestamp = new Timestamp( utilDate.getTime() );

			return timestamp;
		} catch ( Exception e ) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * 
	 * @param oldTime
	 * @return
	 */
	public static boolean compareDates(String oldTime) {
		if(System.currentTimeMillis() >= dateFormat(oldTime)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 判断当前时间是否比oldTime晚second秒,如果是返回true,否则返回false
	 * @param oldTime
	 * @param second
	 * @return boolean
	 */
	public static boolean timeToJudge(String oldTime,int second) {
		//把秒设置成毫秒
		long millisecond = second * 1000;
		//当前时间和原始时间的差毫秒
		long poorMs = System.currentTimeMillis() - dateFormat(oldTime);
		//如果当前时间和原始时间查毫秒比millisecond大，返回true
		if(poorMs >= millisecond) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 
	 * @param second
	 * @return
	 */
	public static Map<String,String> getStartAndEnd(int second) {
		//把秒设置成毫秒
		long millisecond = second * 1000;
		long start = System.currentTimeMillis();
		long end = start + millisecond;
		Map<String, String> map = new HashMap<String, String>();
		map.put("start", dateFormat(start,"yyyyMMddHHmmss"));
		map.put("end", dateFormat(end,"yyyyMMddHHmmss"));
		return map;
	} 
	
	public static String getCurDtStr() {
		Date nowTime = new Date(System.currentTimeMillis());
		SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyyMMdd");
		return sdFormatter.format(nowTime);
	}
	
	public static String getCurDtStr(String datePtn) {
		Date nowTime = new Date(System.currentTimeMillis());
		SimpleDateFormat sdFormatter = new SimpleDateFormat(datePtn);
		return sdFormatter.format(nowTime);
	}
	
	public static String getCurDtsStr() {
		Date nowTime = new Date(System.currentTimeMillis());
		SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdFormatter.format(nowTime);
	}
	
	public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }
	
	public static String getCurDtWeekStr() {
		Date nowTime = new Date(System.currentTimeMillis());
		return getWeekOfDate(nowTime);
	}
	
	public static String stringDateFormat(String date){
		String reString = date.substring(0, 4)+"-"+date.substring(4, 6)+"-"+date.substring(6, 8);
		return reString;
	}
	
	/**
	 * 获得有中文的当天日期(2014年5月22日)
	 * @return
	 */
	public static String getChineseFormatDate() {
		String today = getCurDtStr();
		String chieseDate = today.substring(0, 4);
		if("0".equals(today.substring(4, 5))) {
			chieseDate+="年"+today.substring(5, 6);
		} else {
			chieseDate+="年"+today.substring(4, 6);
		}
		if("0".equals(today.substring(6, 7))) {
			chieseDate+="月"+today.substring(7, 8);
		} else {
			chieseDate+="月"+today.substring(6, 8);
		}
		return chieseDate+"日";
	}
	
	/**
	 * 获得有中文的当天日期(2014年5月22日)
	 * @return
	 */
	public static String getChineseFormatDate(String dts) {
		String chieseDate = dts.substring(0, 4);
		if("0".equals(dts.substring(4, 5))) {
			chieseDate+="年"+dts.substring(5, 6);
		} else {
			chieseDate+="年"+dts.substring(4, 6);
		}
		if("0".equals(dts.substring(6, 7))) {
			chieseDate+="月"+dts.substring(7, 8);
		} else {
			chieseDate+="月"+dts.substring(6, 8);
		}
		return chieseDate+"日";
	}
	
	public static String getDtStrByInterval(String format, int unit, int interval){
		Calendar cal = Calendar.getInstance();
		cal.add(unit, interval);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String rslt = sdf.format(cal.getTime());
		return rslt;
	}
	
	public static String getDtStrByInterval(String fromDt, String format, int unit, int interval) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(fromDt));
		cal.add(unit, interval);
		String rslt = sdf.format(cal.getTime());
		return rslt;
	}
	
	public static String getDtStrByIntervalByOffLendDate(String startDt, String format, int unit,
    		int interval, int day) {
        int year = Integer.parseInt(startDt.substring(0, 4));
        int month = Integer.parseInt(startDt.substring(4, 6));
    	Calendar cal = Calendar.getInstance();
    	cal.set(Calendar.YEAR, year);
    	cal.set(Calendar.MONTH, (month-1));
    	cal.set(Calendar.DAY_OF_MONTH, day);
    	cal.add(unit, interval);
    	SimpleDateFormat sdf = new SimpleDateFormat(format);
    	String rslt = sdf.format(cal.getTime());
    	return rslt;
    }

	/**
	 * 获得从startDt到endDt时间的差(0天18小时0分)
	 * @param startDt
	 * @param endDt
	 * @return
	 */
	public static String getTimeDifferenceDHM(String startDt,String endDt) {
		String diffStr = null;
		if(StringUtils.isNotBlank(startDt) || StringUtils.isNotBlank(endDt)) {
			SimpleDateFormat sd = new SimpleDateFormat("yyyyMMddHHmmss");
			long nd = 1000*24*60*60;//一天的毫秒数
			long nh = 1000*60*60;//一小时的毫秒数
			long nm = 1000*60;//一分钟的毫秒数
			long ns = 1000;//一秒钟的毫秒数
			long diff;
			try {
				diff = sd.parse(endDt).getTime() - sd.parse(startDt).getTime();
				long day = diff/nd;//计算差多少天
				long hour = diff%nd/nh;//计算差多少小时
				long min = diff%nd%nh/nm;//计算差多少分钟
				long sec = diff%nd%nh%nm/ns;//计算差多少秒
				diffStr = day+"天"+hour+"时"+min+"分"+sec+"秒"; 
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			return null;
		}
		return diffStr;
	}
	
	
	/**
	 * 获得从startDt到endDt时间的差(0天18小时0分)
	 * @param startDt
	 * @param endDt
	 * @return
	 */
	public static String getTimeDifferenceDHMStr(String startDt,String endDt) {
		String timestr = null;
		if(StringUtils.isNotBlank(startDt) || StringUtils.isNotBlank(endDt)) {
			SimpleDateFormat sd = new SimpleDateFormat("yyyyMMddHHmmss");
			long nd = 1000*24*60*60;//一天的毫秒数
			long nh = 1000*60*60;//一小时的毫秒数
			long nm = 1000*60;//一分钟的毫秒数
			long ns = 1000;//一秒钟的毫秒数
			long diff;
			try {
				diff = sd.parse(endDt).getTime() - sd.parse(startDt).getTime();
				long day = diff/nd;//计算差多少天
				long hour = diff%nd/nh;//计算差多少小时
				long min = diff%nd%nh/nm;//计算差多少分钟
				long sec = diff%nd%nh%nm/ns;//计算差多少秒
				timestr = day+","+hour+","+min+","+sec;
				return timestr;
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			return null;
		}
		return timestr;
	}
	
	/**
	 * 
	 * @param second
	 * @return
	 */
	public static String secondToStr(int second) {
		StringBuffer sb = new StringBuffer();
		if(second>0) {
			long nd = 1000*24*60*60;//一天的毫秒数
			long nh = 1000*60*60;//一小时的毫秒数
			long nm = 1000*60;//一分钟的毫秒数
			long ns = 1000;//一秒钟的毫秒数
			long diff;
				diff = second * 1000;
				long day = diff/nd;//计算差多少天
				long hour = diff%nd/nh;//计算差多少小时
				long min = diff%nd%nh/nm;//计算差多少分钟
				long sec = diff%nd%nh%nm/ns;//计算差多少秒
				if(day>0) {
					sb.append(day+"天");
				}
				if(hour>0) {
					sb.append(hour+"时");
				}
				if(min>0) {
					sb.append(min+"分");
				}
				if(sec>0) {
					sb.append(sec+"秒");
				}
		} else {
			return null;
		}
		return sb.toString();
	}
	
	/**
	 * 
	 * @param time
	 * @return
	 */
	public static String getGMTDateStr(long time) {
	    Date d = new Date(System.currentTimeMillis() + time);
	    SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH);
	    return dateFormat.format(d);
	}
	
	public static String getGMTDateStr(long time, Locale locale) {
	    Date d = new Date(System.currentTimeMillis() + time);
	    SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", locale);
	    return dateFormat.format(d);
	}
	/**
	 * 获得当前月的第一天
	 * @return
	 */
	public static String getMonthFirstDay() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd"); 
        Calendar cal_1 =Calendar.getInstance();//获取当前日期 
        cal_1.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
        return  format.format(cal_1.getTime());
	}
	/**
	 * 获得当前月的最后一天
	 * @return
	 */
	public static String getMonthLastDay() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Calendar ca = Calendar.getInstance();    
	    ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));  
	    return format.format(ca.getTime());
	}
	
	/**  
	 * 计算两个日期之间相差的天数  
	 * @param smdate 较小的时间 
	 * @param bdate  较大的时间 
	 * @return 相差天数 
	 * @throws ParseException  
	 */
	public static int daysBetween(Date smdate, Date bdate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		smdate = sdf.parse(sdf.format(smdate));
		bdate = sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/** 
	*字符串的日期格式的计算 
	*/
	public static int daysBetween(String smdate, String bdate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(smdate));
		long time1 = cal.getTimeInMillis();
		cal.setTime(sdf.parse(bdate));
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}
	
	/** 
	*字符串的日期格式的计算 
	*/
	public static int daysBetween(String smdate, String bdate,String format) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(smdate));
		long time1 = cal.getTimeInMillis();
		cal.setTime(sdf.parse(bdate));
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}
	
    public static String addDay(String strDate, int i) {  
    	
    	if (StringUtils.isBlank(strDate)) {
    		return null;
    	}
    	Date date = getDate(strDate);
        Calendar c = Calendar.getInstance();  
        c.setTime(date);   //设置当前日期  
        c.add(Calendar.DATE, i); //日期加1天  
        date = c.getTime();  
        return dateFormat(date, "yyyy-MM-dd"); 
    } 
	
	public static void main(String[] args) {
		try {
//			Calendar cal = Calendar.getInstance();
//			cal.add(Calendar.HOUR, -1);
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
//			String rslt = sdf.format(cal.getTime());
//			System.out.println(getGMTDateStr(1800000,Locale.ENGLISH));
//			System.out.println(getGMTDateStr(1800000,Locale.CHINA));
//			System.out.println(getMonthFirstDay());
//			System.out.println(getMonthLastDay());
//			System.out.println(getDtStrByInterval("20140913","yyyyMMdd",Calendar.DATE, 1));
			System.out.println(daysBetween("20141105","20141112"));
//			long lastFinal = DateUtils.parseStringToLong("20141031143343");
//			long lastFirst = DateUtils.parseStringToLong("20141031143824");
//			System.out.println(lastFinal);
//			System.out.println(lastFirst);
//			System.out.println(lastFinal>lastFirst);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	


}

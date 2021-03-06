package com.bl.web.common.utils;

/**
 * <p>Title: miduo360</p>
 * <p>Description: DateUtil </p>
 * <p>Copyright: Copyright (c) 2013</p>
 * <p>Company: Shanghai Mydream Information Technology Co.,Ltd</p>
 * @author
 * @version 1.0
 * history:
 * Date:          Resp            Comment
 * 2011-01-14     Selle Wu        Modify
 */

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.google.common.base.Strings;

public class DateUtil {
	//private static Logger logger = (Logger) LogFactory.getLog( DateUtil.class );

	public DateUtil() {
	}

	/**
	 * 获取系统当前时间
	 * 
	 * @return
	 * @throws UtilDateException
	 */
	public static java.sql.Date getCurrentSqlDate() {
		try {
			java.util.Date utilNow = new java.util.Date();
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
	public static java.util.Date parseDate( java.sql.Date sqlDate ) {
		try {
			java.util.Date utilNow = new java.util.Date( sqlDate.getTime() );
			return utilNow;
		} catch ( Exception e ) {
			e.printStackTrace();
			return null;
		}
	}

	public static java.util.Date getCurrentDate() {
		try {
			java.util.Date utilNow = new java.util.Date();
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
	public static java.sql.Timestamp getCurrentSqlTimestamp() {
		try {
			java.sql.Timestamp timestamp = new java.sql.Timestamp( System.currentTimeMillis() );
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
				return new SimpleDateFormat( "yyyyMMddHHmmss" ).format( new java.util.Date( date ) );
			else
				return new SimpleDateFormat( format ).format( new java.util.Date( date ) );
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
				java.util.Calendar cal = java.util.Calendar.getInstance();
				cal.set( Integer.parseInt( dateStr.substring( 0, 4 ) ), Integer.parseInt( dateStr.substring( 5, 7 ) ) - 1, Integer.parseInt( dateStr.substring( 8, 10 ) ), Integer.parseInt( dateStr.substring( 11, 13 ) ),
						Integer.parseInt( dateStr.substring( 14, 16 ) ), Integer.parseInt( dateStr.substring( 17, 19 ) ) );
				cal.set( java.util.Calendar.MILLISECOND, 0 );
				return ( cal.getTime().getTime() );
			} catch ( Exception e ) {
				return 0;
			}

		} else if ( dateStr.length() == 14 ) {
			try {
				java.util.Calendar cal = java.util.Calendar.getInstance();
				cal.set( Integer.parseInt( dateStr.substring( 0, 4 ) ), Integer.parseInt( dateStr.substring( 4, 6 ) ) - 1, Integer.parseInt( dateStr.substring( 6, 8 ) ), Integer.parseInt( dateStr.substring( 8, 10 ) ),
						Integer.parseInt( dateStr.substring( 10, 12 ) ), Integer.parseInt( dateStr.substring( 12, 14 ) ) );
				cal.set( java.util.Calendar.MILLISECOND, 0 );
				return ( cal.getTime().getTime() );
			} catch ( Exception e ) {
				return 0;
			}
		} else if ( dateStr.length() == 10 ) {
			try {
				java.util.Calendar cal = java.util.Calendar.getInstance();
				cal.set( Integer.parseInt( dateStr.substring( 0, 4 ) ), Integer.parseInt( dateStr.substring( 5, 7 ) ) - 1, Integer.parseInt( dateStr.substring( 8, 10 ) ), 0, 0, 0 );
				cal.set( java.util.Calendar.MILLISECOND, 0 );
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
				java.util.Calendar cal = java.util.Calendar.getInstance();
				cal.set( Integer.parseInt( dateStr.substring( 0, 4 ) ), Integer.parseInt( dateStr.substring( 5, 7 ) ) - 1, Integer.parseInt( dateStr.substring( 8, 10 ) ), Integer.parseInt( dateStr.substring( 11, 13 ) ),
						Integer.parseInt( dateStr.substring( 14, 16 ) ), Integer.parseInt( dateStr.substring( 17, 19 ) ) );
				cal.set( java.util.Calendar.MILLISECOND, 0 );
				return ( cal.getTime().getTime() );
			} catch ( Exception e ) {
				return 0;
			}

		} else if ( dateStr.length() == 14 ) {
			try {
				java.util.Calendar cal = java.util.Calendar.getInstance();
				cal.set( Integer.parseInt( dateStr.substring( 0, 4 ) ), Integer.parseInt( dateStr.substring( 4, 6 ) ) - 1, Integer.parseInt( dateStr.substring( 6, 8 ) ), Integer.parseInt( dateStr.substring( 8, 10 ) ),
						Integer.parseInt( dateStr.substring( 10, 12 ) ), Integer.parseInt( dateStr.substring( 12, 14 ) ) );
				cal.set( java.util.Calendar.MILLISECOND, 0 );
				return ( cal.getTime().getTime() );
			} catch ( Exception e ) {
				return 0;
			}
		} else if ( dateStr.length() == 10 ) {
			try {
				java.util.Calendar cal = java.util.Calendar.getInstance();
				cal.set( Integer.parseInt( dateStr.substring( 0, 4 ) ), Integer.parseInt( dateStr.substring( 5, 7 ) ) - 1, Integer.parseInt( dateStr.substring( 8, 10 ) ), 0, 0, 0 );
				cal.set( java.util.Calendar.MILLISECOND, 0 );
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
			java.util.Date date = new java.util.Date( timestamp );
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
			java.util.Date date = new java.util.Date( timestamp );
			aa = bartDateFormat.format( date );
		} catch ( Exception ex ) {
			//logger.error( ex.getMessage() );
		}
		return aa;
	}

	public static java.util.Date getDate( String name, String df, java.util.Date defaultValue ) {
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

	public static java.util.Date getDateDf( String name, String df ) {
		return getDate( name, df, null );
	}

	public static java.util.Date getDate( String name, String df ) {
		return getDate( name, df, null );
	}

	public static java.util.Date getDate( String name ) {
		return getDate( name, "yyyy-MM-dd", null );
	}

	public static java.util.Date getMonth( String name ) {
		return getDate( name, "yyyy-MM", null );
	}

	public static java.util.Date getDateTime( String name ) {
		return getDateTime( name, null );
	}

	public static java.util.Date getDate( String name, java.util.Date defaultValue ) {
		return getDate( name, "yyyy-MM-dd", defaultValue );
	}

	public static java.util.Date getDateTime( String name, java.util.Date defaultValue ) {
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
	public static String dateFormat( java.util.Date date, String format ) {
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

	public static java.sql.Timestamp parseTimestamp( java.util.Date utilDate ) {
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
		
		if (StringUtils.isBlank(dts)) {
			return null;
		}
		
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
	
	public static String getDtStrByIntervalForRedEnvelope(int unit, int interval){
		String format = "yyyyMMdd";
		Calendar cal = Calendar.getInstance();
		cal.add(unit, interval);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String rslt = sdf.format(cal.getTime()) + "235959";
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
	
	public static String monthDay(String date,Integer month) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(simpleDateFormat.parse(date));
        cal.add(Calendar.MONTH, month);
        return simpleDateFormat.format(cal.getTime());
	}
	
	/**
     * 得到某年某周的第一天
     *
     * @param year
     * @param week
     * @return
     */
    public static Date getFirstDayOfWeek(int year, int week) {
        week = week - 1;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DATE, 1);

        Calendar cal = (Calendar) calendar.clone();
        cal.add(Calendar.DATE, week * 7);

        return getFirstDayOfWeek(cal.getTime());
    }

    /**
     * 得到某年某周的最后一天
     *
     * @param year
     * @param week
     * @return
     */
    public static Date getLastDayOfWeek(int year, int week) {
        week = week - 1;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DATE, 1);
        Calendar cal = (Calendar) calendar.clone();
        cal.add(Calendar.DATE, week * 7);

        return getLastDayOfWeek(cal.getTime());
    }

    /**
     * 取得当前日期所在周的第一天
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK,
                      calendar.getFirstDayOfWeek()); // Sunday
        return calendar.getTime();
    }

    /**
     * 取得当前日期所在周的最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK,
                     calendar.getFirstDayOfWeek() + 6); // Saturday
        return calendar.getTime();
    }

    /**
     * 取得当前日期所在周的前一周最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfLastWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getLastDayOfWeek(calendar.get(Calendar.YEAR),
                                calendar.get(Calendar.WEEK_OF_YEAR) - 1);
    }

    /**
     * 返回指定日期的月的第一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getFirstDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR),
                     calendar.get(Calendar.MONTH), 1);
        return calendar.getTime();
    }

    /**
     * 返回指定年月的月的第一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getFirstDayOfMonth(Integer year, Integer month) {
        Calendar calendar = Calendar.getInstance();
        if (year == null) {
            year = calendar.get(Calendar.YEAR);
        }
        if (month == null) {
            month = calendar.get(Calendar.MONTH);
        }
        calendar.set(year, month, 1);
        return calendar.getTime();
    }

    /**
     * 返回指定日期的月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR),
                     calendar.get(Calendar.MONTH), 1);
        calendar.roll(Calendar.DATE, -1);
        return calendar.getTime();
    }

    /**
     * 返回指定年月的月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getLastDayOfMonth(Integer year, Integer month) {
        Calendar calendar = Calendar.getInstance();
        if (year == null) {
            year = calendar.get(Calendar.YEAR);
        }
        if (month == null) {
            month = calendar.get(Calendar.MONTH);
        }
        calendar.set(year, month, 1);
        calendar.roll(Calendar.DATE, -1);
        return calendar.getTime();
    }

    /**
     * 返回指定日期的上个月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getLastDayOfLastMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR),
                     calendar.get(Calendar.MONTH) - 1, 1);
        calendar.roll(Calendar.DATE, -1);
        return calendar.getTime();
    }

    /**
     * 返回指定日期的季的第一天
     *
     * @param year
     * @param quarter
     * @return
     */
    public static Date getFirstDayOfQuarter(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getFirstDayOfQuarter(calendar.get(Calendar.YEAR),
                                    getQuarterOfYear(date));
    }

    /**
     * 返回指定年季的季的第一天
     *
     * @param year
     * @param quarter
     * @return
     */
    public static Date getFirstDayOfQuarter(Integer year, Integer quarter) {
        Calendar calendar = Calendar.getInstance();
        Integer month = new Integer(0);
        if (quarter == 1) {
            month = 1 - 1;
        } else if (quarter == 2) {
            month = 4 - 1;
        } else if (quarter == 3) {
            month = 7 - 1;
        } else if (quarter == 4) {
            month = 10 - 1;
        } else {
            month = calendar.get(Calendar.MONTH);
        }
        return getFirstDayOfMonth(year, month);
    }

    /**
     * 返回指定日期的季的最后一天
     *
     * @param year
     * @param quarter
     * @return
     */
    public static Date getLastDayOfQuarter(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getLastDayOfQuarter(calendar.get(Calendar.YEAR),
                                   getQuarterOfYear(date));
    }

    /**
     * 返回指定年季的季的最后一天
     *
     * @param year
     * @param quarter
     * @return
     */
    public static Date getLastDayOfQuarter(Integer year, Integer quarter) {
        Calendar calendar = Calendar.getInstance();
        Integer month = new Integer(0);
        if (quarter == 1) {
            month = 3 - 1;
        } else if (quarter == 2) {
            month = 6 - 1;
        } else if (quarter == 3) {
            month = 9 - 1;
        } else if (quarter == 4) {
            month = 12 - 1;
        } else {
            month = calendar.get(Calendar.MONTH);
        }
        return getLastDayOfMonth(year, month);
    }

    /**
     * 返回指定日期的上一季的最后一天
     *
     * @param year
     * @param quarter
     * @return
     */
    public static Date getLastDayOfLastQuarter(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getLastDayOfLastQuarter(calendar.get(Calendar.YEAR),
                                       getQuarterOfYear(date));
    }

    /**
     * 返回指定年季的上一季的最后一天
     *
     * @param year
     * @param quarter
     * @return
     */
    public static Date getLastDayOfLastQuarter(Integer year, Integer quarter) {
        Calendar calendar = Calendar.getInstance();
        Integer month = new Integer(0);
        if (quarter == 1) {
            month = 12 - 1;
        } else if (quarter == 2) {
            month = 3 - 1;
        } else if (quarter == 3) {
            month = 6 - 1;
        } else if (quarter == 4) {
            month = 9 - 1;
        } else {
            month = calendar.get(Calendar.MONTH);
        }
        return getLastDayOfMonth(year, month);
    }

    /**
     * 返回指定日期的季度
     *
     * @param date
     * @return
     */
    public static int getQuarterOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) / 3 + 1;
    }
	public static void main(String[] args) {
//		Calendar cal = Calendar.getInstance();
//		cal.add(Calendar.HOUR, -1);
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
//		String rslt = sdf.format(cal.getTime());
//	    System.out.println(rslt);
		int iDays= 1;
		if(!Strings.isNullOrEmpty("3")){
			iDays = Integer.parseInt("3");
		}
		System.out.println(iDays);
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        String str = "2015-07-28";
//        Date date=null;
//		try {
//			date = df.parse(str);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        
//        System.out.println("当月第一天：" + df.format(getFirstDayOfMonth(date)));
//        System.out.println("当月最后一天：" + df.format(getLastDayOfMonth(date)));
        

//		try {
//			System.out.println(monthDay("20141028",-1));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(getGMTDateStr(1800000,Locale.ENGLISH));
//		System.out.println(getGMTDateStr(1800000,Locale.CHINA));
	}
	
}

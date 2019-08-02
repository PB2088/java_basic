package org.pb.util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *  日期处理工具类
 * @author bo.peng
 *
 */
public final class DateUtil {
	
	public enum FormatPattern {
		
		/** 格式：yyyy-MM-dd */
		DATE_FORMAT_PATTERN("yyyy-MM-dd"),
		
		/** 格式：yyyy-MM-dd HH:mm:ss */
        DATE_TIME_FORMAT_PATTERN("yyyy-MM-dd HH:mm:ss"),

        /** 格式：yyyy-MM-dd HH:mm:ss SSS */
        DATE_TIME_SSS_FORMAT_PATTERN("yyyy-MM-dd HH:mm:ss SSS"),
		
		/** 格式：yyyy年MM月dd日 */
		DATE_CN_FORMAT_PATTERN("yyyy年MM月dd日"),
		
		/** 格式：yyyy年MM月dd日 HH时mm分ss秒 */
		DATE_TIME_CN_FORMAT_PATTERN("yyyy年MM月dd日 HH时mm分ss秒"),
		
		/** 格式：yyyyMMdd */
		DATE_TIME_YMD_FORMAT_PATTERN("yyyyMMdd");
		
		private String pattern;
		
		private FormatPattern(String pattern) {
			this.pattern = pattern;
		}
		
		public String getPattern() {
			return pattern;
		}
	}
    
    /** 锁对象 */
    private static final Object LOCK_OBJ = new Object();

    /** 存放不同的日期模板格式的formatMap的Map */
    private static Map<String, ThreadLocal<SimpleDateFormat>> formatMap = new HashMap<String, ThreadLocal<SimpleDateFormat>>();

    /**
     * 获取根据解析模板获取ThreadLocal的formatMap,每个线程只会new一次formatMap
     * @param pattern
     * @return
     */
    private static SimpleDateFormat getSimpleDateFormat(final String pattern) {
        ThreadLocal<SimpleDateFormat> tl = formatMap.get(pattern);

        /** 此处的双重判断和同步是为了防止formatMap这个单例被多次put重复的formatMap */
        if (tl == null) {
            synchronized (LOCK_OBJ) {
                tl = formatMap.get(pattern);
                if (tl == null) {
                    /** 使用ThreadLocal<SimpleDateFormat>替代原来直接new SimpleDateFormat */
                    tl = new ThreadLocal<SimpleDateFormat>() {
                    	
                        @Override
                        protected SimpleDateFormat initialValue() {
                            return new SimpleDateFormat(pattern);
                        }
                    };
                    
                    formatMap.put(pattern, tl);
                }
            }
        }

        return tl.get();
    }
    
    public static SimpleDateFormat getSimpleDateFormat(FormatPattern formatPattern) {
    	return getSimpleDateFormat(formatPattern.getPattern());
    }

    
    /**
     * 将日期对象解析为日期字符串
     * @param date 待解析的日期对象
     * @param pattern 解析模板
     * @return 日期字符串
     */
    public static String parseDateToStr(Date date, FormatPattern pattern) {
        return ToolsUtils.isEmpty(date)?null:
        	getSimpleDateFormat(pattern.getPattern()).format(date);
    }

    /**
     * 将日期字符串解析为日期对象
     * @param dateStr 日期字符串
     * @param pattern 解析模板
     * @return Date对象
     * @throws ParseException
     */
    public static Date parseStrToDate(String dateStr,FormatPattern pattern) throws ParseException {
		return ToolsUtils.isEmpty(dateStr) ? null : 
			getSimpleDateFormat(pattern.getPattern()).parse(dateStr);
    }
    
    /**
     * 
     * <p>Description:将日期字符串解析为日期对象,并可设置指定时，分，秒</p>
     * Created on:2016-8-6 下午1:37:40
     * @Author:peng.bo
     * @param dateStr 日期字符串
     * @param pattern 解析模板
     * @param hour 要设置的时
     * @param minute 要设置的分
     * @param second 要设置的秒
     * @return
     * @throws ParseException
     */
    public static Date parseStrToDate(String dateStr,FormatPattern pattern,int hour,int minute,int second) throws ParseException {
    	Calendar calendar = Calendar.getInstance();
		calendar.setTime(parseStrToDate(dateStr, pattern));
		
    	calendar.set(Calendar.HOUR, hour);
    	calendar.set(Calendar.MINUTE, minute);
    	calendar.set(Calendar.SECOND, second);
		
		return calendar.getTime();
    }
    
    /**
     * <p>Description:判断某个日期是星期几,返回数字1~7，对应周一到周日</p>
     * Created on:2017-5-31 下午1:37:40
     * @param date
     * @return
     */
    public static int dateGetWeekDay(Date date){
    	  Calendar c = Calendar.getInstance(); 
    	  c.setTime(date); 
    	  int dayForWeek = 0; 
    	  if(c.get(Calendar.DAY_OF_WEEK) == 1){ 
    	   dayForWeek = 7; 
    	  }else{ 
    	   dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1; 
    	  } 
    	  return dayForWeek;
    }

	/**
	 * <p>获取一个当前日期对象</p>
	 * @return
	 */
	public static Date now() {
		return new Date();
	}
    
    public static void main(String[] args) throws ParseException {
    	Date date = parseStrToDate("2016年8月17日", FormatPattern.DATE_CN_FORMAT_PATTERN,00,0,0);
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	Date date1 = format.parse( "2008-09-14" );
        /** 判断某个日期为星期几 */
    	System.out.println(dateGetWeekDay(date1));
    	/** 判断几天为星期几 */
    	System.out.println(dateGetWeekDay(new Date()));
		System.out.println(parseDateToStr(date, FormatPattern.DATE_TIME_FORMAT_PATTERN));
		System.out.println(parseDateToStr(new Date(), FormatPattern.DATE_TIME_YMD_FORMAT_PATTERN));

		System.out.println(now().getTime());
		System.out.println(parseStrToDate("2017-08-02 10:23:59", FormatPattern.DATE_TIME_FORMAT_PATTERN).getTime());
		System.out.println(now().getTime() - parseStrToDate("2017-08-02 10:23:59", FormatPattern.DATE_TIME_FORMAT_PATTERN).getTime());
		System.out.println(parseStrToDate("2017-08-02 10:23:59", FormatPattern.DATE_TIME_FORMAT_PATTERN).getTime() - now().getTime());
	}
}
package com.zyf.busilog.common.utils;

import org.apache.commons.lang.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateHelper {

    protected static final Logger logger = LoggerFactory.getLogger(DateHelper.class);
    public static final String SDF_YMD1 = "yyyy-MM-dd";
    public static final String SDF_YMD2 = "yyyy/MM/dd";
    public static final String SDF_YMD3 = "yyyy年MM月dd日";
    public static final String SDF_YMDHMS1 = "yyyy-MM-dd HH:mm:ss";
    public static final String SDF_YMDHMS2 = "yyyy-MM-dd hh:mm:ss";
    public static final String SDF_YMDHMS3 = "yyyy年MM月dd日HH时mm分ss秒";
    public static final String SDF_YMD_HMSSSS = "yyyy-MM-dd-HH:mm:ss.SSS";
    public static final String SDF_YMD_HMSSSSSSS = "yyyy-MM-dd HH:mm:ss.SSS000";
    public static final String SDF_YMDHMSSSS = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String[] DATE_PATTERNS = new String[]{"yyyy-MM-dd"};
    public static final String[] CONVERT_DATE_PATTERNS = new String[]{"yyyy-MM-dd", "yyyy/MM/dd", "yyyy年MM月dd日", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd hh:mm:ss"};

    public DateHelper() {
    }

    public static Date buildDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        return calendar.getTime();
    }

    public static int getDateMargin(Date start, Date end) {
        Long margin = end.getTime() - start.getTime();
        margin = margin / 86400000L;
        return margin.intValue();
    }

    public static int getDateMargin(long start, long end) {
        Long margin = end - start;
        margin = margin / 86400000L;
        return margin.intValue();
    }

    public static int getDateMargin(String start, String end) {
        return getDateMargin(stringToDate(start), stringToDate(end));
    }

    public static int getHoursMargin(Date start, Date end) {
        Long margin = end.getTime() - start.getTime();
        margin = margin / 3600000L;
        return margin.intValue();
    }

    public static int getHoursMargin(long start, long end) {
        Long margin = end - start;
        margin = margin / 3600000L;
        return margin.intValue();
    }

    public static int getHoursMargin(String start, String end) {
        return getHoursMargin(stringToDate(start), stringToDate(end));
    }

    public static String getDateString() {
        return getDateString("yyyy-MM-dd");
    }

    public static String getDateString(Date date, String partten) {
        if (date == null) {
            date = nowDate();
        }

        String result = null;
        SimpleDateFormat formatter = new SimpleDateFormat(partten);
        result = formatter.format(date);
        return result;
    }

    public static String getDateString(Long time, String partten) {
        return getDateString(new Date(time), partten);
    }

    public static String getDateString(String partten) {
        return getDateString(nowDate(), partten);
    }

    public static int getDayCountOfMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, year);
        calendar.set(2, month);
        calendar.set(5, 0);
        return calendar.get(5);
    }

    public static Date getFirstDateOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(5, 1);
        return calendar.getTime();
    }

    public static Date getFirstDayOfMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, year);
        calendar.set(2, month - 1);
        calendar.set(5, 1);
        return calendar.getTime();
    }

    public static Date getFirstDayOfQuarter(int year, int quarter) {
        if (quarter > 4) {
            return null;
        } else {
            int month = (quarter - 1) * 3 + 1;
            return getFirstDayOfMonth(year, month);
        }
    }

    public static Date getFirstDayOfYear(int year) {
        return getFirstDayOfMonth(year, 1);
    }

    public static Date getLastDateOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(2, 1);
        calendar.set(5, 1);
        return getPrevDate(calendar.getTime(), 1);
    }

    public static Date getLastDayOfMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, year);
        calendar.set(2, month);
        calendar.set(5, 1);
        return getPrevDate(calendar.getTime(), 1);
    }

    public static int getQuarterOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(2);
        if (month < 3) {
            return 1;
        } else if (month < 6) {
            return 2;
        } else {
            return month < 9 ? 3 : 4;
        }
    }

    public static Date getLastDayOfQuarter(int year, int quarter) {
        if (quarter > 4) {
            return null;
        } else {
            int month = quarter * 3;
            return getLastDayOfMonth(year, month);
        }
    }

    public static Date getLastDayOfYear(int year) {
        return getLastDayOfMonth(year, 12);
    }

    public static Date getNextMonth(Date date, int next) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(2, next);
        return calendar.getTime();
    }

    public static String getNextMonthString(Date date, int next, String partten) {
        return getDateString(getNextMonth(date, next), partten);
    }

    public static Date getNextDate(Date date, int next) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(5, next);
        return calendar.getTime();
    }

    public static String getNextDateString(Date date, int next, String partten) {
        return getDateString(getNextDate(date, next), partten);
    }

    public static Date getNextMinute(Date date, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(12, minute);
        return calendar.getTime();
    }

    public static String getNextMinuteString(Date date, int minute, String partten) {
        return getDateString(getNextMinute(date, minute), partten);
    }

    public static Date getNextYear(Date currentDate, int next) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(currentDate);
        cal.add(1, next);
        return cal.getTime();
    }

    public static String getNextYearString(Date currentDate, int next) {
        Date nextYear = getNextYear(currentDate, next);
        return getDateString(nextYear, "yyyy");
    }

    public static Date getPrevDate(Date date, int Prev) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(5, 0 - Prev);
        return calendar.getTime();
    }

    public static String getPrevDateString(Date date, int Prev, String partten) {
        return getDateString(getPrevDate(date, Prev), partten);
    }

    public static Date getWeekFirstDate(Date date) {
        return getWeekFirstDate(date, true);
    }

    public static Date getWeekFirstDate(Date date, boolean isSundayStartDay) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(7);
        if (dayOfWeek == 1 && !isSundayStartDay) {
            dayOfWeek += 7;
        }

        calendar.set(6, calendar.get(6) - dayOfWeek + 2);
        return calendar.getTime();
    }

    public static Date getWeekLastDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(7);
        calendar.set(6, calendar.get(6) - dayOfWeek + 2);
        calendar.set(6, calendar.get(6) + 6);
        return calendar.getTime();
    }

    public static Date nowDate() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    public static Date stringToDate(String param) {
        return stringToDate(param, (String)null);
    }

    public static Date stringToDate(String param, String partten) {
    	if(StrHelper.isEmpty(param)) {
    		return null;
    	}
        if (StrHelper.isEmpty(partten)) {
            partten = "yyyy-MM-dd";
        }
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat(partten);
        param = param.replaceAll("年", "-").replaceAll("月", "-").replaceAll("日", "").replaceAll("/", "-");
        param = param.replaceAll("T", " ").replaceAll("时", ":").replaceAll("分", ":").replaceAll("秒", "");

        try {
            date = sdf.parse(param);
        } catch (ParseException var5) {
            logger.error("将{0}转换为Date型发生异常[{1}]，返回默认值：null", new Object[]{param, var5.getMessage()});
            return null;
        }
        return new Date(date.getTime());
    }

    public static String chineseDateStr() {
        return (new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒")).format(new Date());
    }

    public static String getCurrTimeStr() {
        return getDateString("yyyyMMdd");
    }

    public static int daysBetween(String start, String end) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(stringToDate(start));
        long time1 = cal.getTimeInMillis();
        cal.setTime(stringToDate(end));
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / 86400000L;
        return Integer.parseInt(String.valueOf(between_days));
    }

    public static int daysBetween(Date start, Date end) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(start);
        long time1 = cal.getTimeInMillis();
        cal.setTime(end);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / 86400000L;
        return Integer.parseInt(String.valueOf(between_days));
    }

    public static long getTimeDifference(long statrTime) {
        return nowDate().getTime() - statrTime;
    }

    public static String formatUTC(Date date) {
        return formatUTC(date, "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    }

    public static String formatUTC(String date) {
        return formatUTC(stringToDate(date, "yyyy-MM-dd HH:mm:ss"));
    }

    public static String formatUTC(String date, String partten) {
        return formatUTC(stringToDate(date, "yyyy-MM-dd HH:mm:ss"), partten);
    }

    public static String formatUTC(Date date, String partten) {
        return DateFormatUtils.formatUTC(date.getTime(), partten);
    }

    public static Date toUTC(Date date) {
        return toUTC(date, "yyyy-MM-dd HH:mm:ss.SSS");
    }

    public static Date toUTC(Date date, String partten) {
        return stringToDate(formatUTC(date), partten);
    }

    public static String formatLocalFromUTC(String UTCTime) {
        return formatLocalFromUTC(UTCTime, "yyyy-MM-dd HH:mm:ss.SSS");
    }

    public static String formatLocalFromUTC(String UTCTime, String partten) {
        SimpleDateFormat utcFormater = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        utcFormater.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date gpsUTCDate = null;

        try {
            gpsUTCDate = utcFormater.parse(UTCTime);
        } catch (ParseException var6) {
            logger.error("UTC Date String[{0}]转换为UTCDate类型错误", new Object[]{UTCTime, var6});
        }

        SimpleDateFormat localFormater = new SimpleDateFormat(partten);
        localFormater.setTimeZone(TimeZone.getDefault());
        String localTime = localFormater.format(gpsUTCDate.getTime());
        return localTime;
    }

    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    public static boolean isLastDateOfMonth(String date) {
        return isLastDateOfMonth(stringToDate(date));
    }

    public static boolean isLastDateOfMonth(Date date) {
        Date lastDate = getLastDateOfMonth(date);
        return isSameDate(date, lastDate);
    }

    public static boolean isSameDate(Date d1, Date d2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(d1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(d2);
        return cal1.get(1) == cal2.get(1) && cal1.get(2) == cal2.get(2) && cal1.get(5) == cal2.get(5);
    }
    /**
     * 获取Date的字符串年份
     *
     * @param date
     * @return
     */
    public static String getDateYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR) + "";
    }

    /**
     * 获取Date的字符串月份（补0）
     *
     * @param date
     * @return
     */
    public static String getDateMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH) + 1;
        return (month < 10 ? "0" : "") + month;
    }

    /**
     * 判断两个日期的年月是否相同
     *
     * @param d1
     * @param d2
     * @return
     */
    public static boolean isSameDateYearMonth(Date d1, Date d2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(d1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(d2);
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
    }

    /**
     * 判断日期是否是周末
     *
     * @param date
     * @return
     */
    public static boolean isWeekend(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;
    }

    /**
     * 获取较大的日期
     *
     * @param d1
     * @param d2
     * @return
     */
    public static Date getBiggerDate(Date d1, Date d2){
        return d1.compareTo(d2) > 0 ? d1 : d2;
    }

    /**
     * 获取较大的日期
     *
     * @param d1
     * @param d2
     * @return
     */
    public static Date getSmallerDate(Date d1, Date d2){
        return d1.compareTo(d2) > 0 ? d2 : d1;
    }
}

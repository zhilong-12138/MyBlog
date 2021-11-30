package com.zhy.utils;

import org.apache.logging.log4j.core.util.datetime.FastDateFormat;

import java.util.Date;

/**
 * @author ding
 * @date 2020-12-08 15:17
 */
public class DateUtil {
    public final static FastDateFormat YYYYMMDDHHMMSS_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss" );

    /**
     * 获取当前时间Unix时间戳，单位：秒，长度：10位
     *
     * @return int 10位长度时间戳
     */
    public static int getTimestamp() {
        return new Long(System.currentTimeMillis() / 1000).intValue();
    }

    /**
     * 将字符串年月日时分秒转换为时间戳
     *
     * @param date String yyyy-MM-dd HH:mm:ss
     * @return int 10位长度时间戳
     */
    public static int getTimestamp(String date) {
        int unixTime = 0;
        try {
            Date parse = YYYYMMDDHHMMSS_FORMAT.parse(date);
            unixTime = Integer.parseInt(String.valueOf(parse.getTime() / 1000));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return unixTime;
    }

    /**
     * 将字符串的日期转为时间戳，可自己指定灵活的日期格式
     *
     * @param date    "08-19 11:23"
     * @param pattern "MM-dd HH:mm" https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html
     * @return int 10位长度时间戳
     */
    public static int getTimestamp(String date, String pattern) {
        FastDateFormat fastDateFormat = FastDateFormat.getInstance(pattern);
        int unixTime = 0;
        try {
            unixTime = Integer.parseInt(String.valueOf(fastDateFormat.parse(date).getTime() / 1000));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return unixTime;
    }

    /**
     * 将Date日期转为时间戳
     *
     * @param date Date
     * @return int 10位长度时间戳
     */
    public static int getTimestamp(Date date) {
        return Integer.parseInt(String.valueOf(date.getTime() / 1000));
    }

    /**
     * Java获取微秒，返回示例 ：1613955046299159（长度16位long）
     * 格式化输出 System.out.printf("%.6f", microsecond / 10000000.00);
     * 格式化字符串 String.format("%.6f", microsecond / 10000000.00);
     *
     * @return long
     */
    public static long getMicrosecond() {
        //毫秒
        long millisecond = System.currentTimeMillis();
        //纳秒
        long nanoTime = System.nanoTime();
        //取微秒
        // long microsecond = millisecond * 1000 - (nanoTime - nanoTime / 1000000 * 1000000 ) / 1000;

        //格式化输出 System.out.printf("%.6f", microsecond / 10000000.00);
        //格式化字符串 String.format("%.6f", microsecond / 10000000.00);

        return millisecond * 1000 - (nanoTime - nanoTime / 1000000 * 1000000) / 1000;
    }

    /**
     * 返回当前日期时间 格式：yyyy-MM-dd HH:mm:ss
     *
     * @return String 2020-12-11 10:22:13
     */
    public static String formatDate() {
        return FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss" ).format(new Date());
    }

    /**
     * 根据规则返回指定格式的当前日期时间
     * pattern 与SimpleDateFormat 完全一致，可参考
     *
     * @param pattern 如：yyyy-MM-dd HH:mm:ss https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html
     * @return String 2020-12-11 10:22:13
     */
    public static String formatDate(String pattern) {
        return FastDateFormat.getInstance(pattern).format(new Date());
    }

    /**
     * 根据日期和规则返回指定格式日期
     *
     * @param date    Date
     * @param pattern 如：yyyy-MM-dd HH:mm:ss https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html
     * @return String 2020-12-11 10:22:13
     */
    public static String formatDate(Date date, String pattern) {
        return FastDateFormat.getInstance(pattern).format(date);
    }

    /**
     * 根据时间戳转指定格式的日期
     *
     * @param timestamp 1597828330 10位
     * @param pattern   如：yyyy-MM-dd HH:mm:ss https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html
     * @return String
     */
    public static String formatDate(int timestamp, String pattern) {
        return FastDateFormat.getInstance(pattern).format((long) timestamp * 1000);
    }

    /**
     * 根据时间戳转 Date 类型
     *
     * @param timestamp 1597828330 10位
     * @return Date
     */
    public static Date formatDate(int timestamp) {
        return new Date((long) timestamp * 1000);
    }

    /**
     * 根据String Date 转 Date类型
     * @param date string
     * @return Date
     */
    public static Date formatStringToDate(String date) {
        return formatDate(getTimestamp(date));
    }

}

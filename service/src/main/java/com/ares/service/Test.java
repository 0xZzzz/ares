package com.ares.service;

/**
 * @author  0xZzzz
 * @date 2020/2/25
 */
public class Test {

    /**
     * 1秒钟的毫秒数
     */
    public final static long ONE_SECOND_MILLIS = 1000;

    /**
     * 一分钟的毫秒数
     */
    public static final long ONE_MINUTE_MILLIS = ONE_SECOND_MILLIS * 60;

    /**
     * 一小时的毫秒数
     */
    public static final long ONE_HOUR_MILLIS = ONE_MINUTE_MILLIS * 60;

    /**
     * 一天的毫秒数
     */
    public final static long ONE_DAY_MILLIS = ONE_HOUR_MILLIS * 24;

    public static void main(String[] args) {
        System.out.println(parseTimeoutExpression(60000L));
    }

    /**
     * 解析超时表达式，目前最小只能支持到分钟级别
     */
    private static String parseTimeoutExpression(Long timeout) {
        if (timeout > ONE_DAY_MILLIS && timeout % ONE_DAY_MILLIS == 0) {
            long day = timeout / ONE_DAY_MILLIS;
            return day + "d";
        }
        if (timeout > ONE_HOUR_MILLIS && timeout % ONE_HOUR_MILLIS == 0) {
            long hour = timeout / ONE_HOUR_MILLIS;
            return hour + "h";
        }
        long minute = timeout / ONE_MINUTE_MILLIS;
        return minute + "m";
    }

}

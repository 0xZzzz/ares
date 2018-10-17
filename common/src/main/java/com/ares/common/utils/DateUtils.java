package com.ares.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * 日期工具类
 */
public class DateUtils {

    public static final String NUM_FORMAT = "yyyyMMddHHmmss";

    public static final String MS_NUM_FORMAT = NUM_FORMAT + "SSS";

    public static final String COMMON_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String MS_COMMON_FORMAT = COMMON_FORMAT + ".SSS";

    public static final DateTimeFormatter COMMON_FORMATTER = DateTimeFormatter.ofPattern(COMMON_FORMAT);

    public static final DateTimeFormatter MS_COMMON_FORMATTER = DateTimeFormatter.ofPattern(MS_COMMON_FORMAT);

    public static final DateTimeFormatter MS_NUM_FORMATTER = DateTimeFormatter.ofPattern(MS_NUM_FORMAT);

    /**
     * 格式化毫秒时间戳
     */
    public static String format(long millis) {
        return format(millis, COMMON_FORMATTER);
    }

    /**
     * 格式化毫秒时间戳
     */
    public static String format(long millis, DateTimeFormatter formatter) {
        return formatter.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(millis), ZoneId.of("Asia/Shanghai")));
    }

    /**
     * 解析字符串为毫秒时间戳
     */
    public static long parseMillis(String text, String format) {
        try {
            return new SimpleDateFormat(format).parse(text).getTime();
        } catch (ParseException e) {
            return 0;
        }
    }

}

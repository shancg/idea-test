package com.example.demo.common.utils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * LocalDateUtil.class
 * <p>
 * User: IT-Reverb
 * Date: 2018/5/11
 * Time: 9:38
 */
public class LocalDateUtil {

    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getNowTimeStr() {
        LocalDateTime time = LocalDateTime.now();
        return formatterLocalDateTime("yyyy-MM-dd HH:mm:ss", time);
    }

    /**
     * @param fomatter      时间格式
     * @param localDateTime 需要转换的时间类型
     * @return
     */
    public static String formatterLocalDateTime(String fomatter, LocalDateTime localDateTime) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(fomatter);
        return df.format(localDateTime);
    }

    /**
     * 把字符串类型时间转换为Date
     *
     * @param fomatter 时间格式
     * @param dateStr  需要转换的dateStr类型
     * @return
     */
    public static Date parseStringToDate(String fomatter, String dateStr) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(fomatter);
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.parse(dateStr, df);
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        return Date.from(zdt.toInstant());
    }


    /**
     * 把已知date类型转化为String时间 格式为yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static String getTimeToDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        return formatterLocalDateTime("yyyy-MM-dd HH:mm:ss", localDateTime);

    }

    /**
     * 获取long类型当前时间戳
     *
     * @return
     */
    public static long getTimeStamp() {
        return LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    /**
     * 获取当前的Date
     *
     * @return
     */
    public static Date getDate() {
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        return Date.from(zdt.toInstant());
    }

}

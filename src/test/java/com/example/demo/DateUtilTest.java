package com.example.demo;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author shancg
 * @data 2018/8/30
 */
public class DateUtilTest {


    public static void main(String[] args) {

        LocalDateTime time = LocalDateTime.now();
        System.out.println(time);

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String stime = df.format(time);
        System.out.println(stime);

        String timestr = "2018-08-30 01:51:29";
        LocalDateTime time1 = LocalDateTime.parse(timestr,df);
        System.out.println(time1);

        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = time.atZone(zoneId);
        Date date = Date.from(zdt.toInstant());
        System.out.println(date);

        Instant instant = date.toInstant();
        ZonedDateTime zdt1 = instant.atZone(zoneId);
        LocalDateTime localDateTime = zdt1.toLocalDateTime();
        System.out.println(localDateTime);

        long timeStamp = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        System.out.println(timeStamp);
        System.out.println(System.currentTimeMillis());

    }
}

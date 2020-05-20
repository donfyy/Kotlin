package com.donfyy.java;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class MyDate {

    /**
     *
     * @param targetDateStr
     * @param inputPattern
     * @return -1 means targetDateStr is before today or invalid input
     */
    public static int getDayCountToToday(String targetDateStr, String inputPattern){
        try {
            Date desDate = null;
            DateFormat dateInstance = DateFormat.getInstance();
            if (dateInstance instanceof SimpleDateFormat) {
                ((SimpleDateFormat) dateInstance).applyPattern(inputPattern);
//                dateInstance.setTimeZone(TimeZone.getTimeZone("UTC"));
                dateInstance.setTimeZone(TimeZone.getTimeZone("America/New_York"));
                desDate = dateInstance.parse(targetDateStr);
            }

            if (desDate == null) {
                return -1;
            }

            Calendar des = convertTimeToStartOfDay(desDate.getTime());
            Calendar today = convertTimeToStartOfDay(System.currentTimeMillis());

            long offset = des.getTimeInMillis() - today.getTimeInMillis();

            int ret = (int) (offset / TimeUnit.DAYS.toMillis(1));
            return ret < 0 ? -1 : ret;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    private static Calendar convertTimeToStartOfDay(long mills) {
        Calendar input = Calendar.getInstance();
//        input.setTimeZone(TimeZone.getTimeZone("UTC"));
        input.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        input.setTimeInMillis(mills);

        Calendar output = Calendar.getInstance();
        output.setTimeZone(TimeZone.getTimeZone("America/New_York"));
//        output.setTimeZone(TimeZone.getTimeZone("UTC"));
        output.set(
                input.get(Calendar.YEAR),
                input.get(Calendar.MONTH),
                input.get(Calendar.DAY_OF_MONTH),
                0,0,0
        );

        return output;
    }

    public static void main(String... args) throws ParseException {
        int count = getDayCountToToday("2020-09-03", "yyyy-MM-dd");
        System.out.println(count);


        long l = System.currentTimeMillis();
        SimpleDateFormat local = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat utcLocal = new SimpleDateFormat("yyyy-MM-dd");
        utcLocal.setTimeZone(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat usLocal = new SimpleDateFormat("yyyy-MM-dd");
        usLocal.setTimeZone(TimeZone.getTimeZone("America/New_York"));

        System.out.println(local.format(new Date(l)));
        System.out.println(utcLocal.format(new Date(l)));
        System.out.println(usLocal.format(new Date(l)));
       /* long mills = System.currentTimeMillis();
        Calendar calendar = convertTimeToStartOfDay(mills);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat jpDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        jpDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));
        System.out.println("-----------");

        System.out.println(simpleDateFormat.format(mills));
        System.out.println(jpDateFormat.format(mills));
        System.out.println("-----------");

        System.out.println("now:" + simpleDateFormat.format(new Date(mills)) + " :" + simpleDateFormat.format(new Date(calendar.getTimeInMillis())));
//        int interval = getDayCountToToday("20190401", "yyyyMMdd");
//        System.out.println(interval);

        int yyyyMMdd = getDayCountToToday("20200328", "yyyyMMdd");
        System.out.println(yyyyMMdd);


        SimpleDateFormat utc = new SimpleDateFormat("yyyyMMdd");
        utc.setTimeZone(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat defaultTimezone = new SimpleDateFormat("yyyyMMdd");
        System.out.println(
                "utc:" + utc.parse("20200327").getTime() +
                        "default:" + defaultTimezone.parse("20200327").getTime()
        );


        System.out.println(Objects.equals("", ""));*/
    }

}

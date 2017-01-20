package com.wpmac.mzehtapi.utils;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by yaoyan on 16/12/19.
 */
public class DateUtil {

    private final static String DATE_FORMATER = "yyyy-MM-dd HH:mm:ss";

    public static String getDefaultCurrentDate() {
        return DateFormatUtils.format(new Date(), DATE_FORMATER);
    }

    public static String getCurrentDate(String pattern){
        return DateFormatUtils.format(new Date(), pattern);
    }

    public static String createByDays(Date date, int days, String format) {
        if(format == null || "".equals(format)) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return String.valueOf(dateFormat.format(calendar.getTime()));
    }

    public static String createByMonths(Date date, int month, String format) {
        if(format == null || "".equals(format)) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, month);
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return String.valueOf(dateFormat.format(calendar.getTime()));
    }

    public static String createByYears(Date date, int year, String format) {
        if(format == null || "".equals(format)) {
            format = "yyyy-MM-dd HH:mm:ss";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, year);
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return String.valueOf(dateFormat.format(calendar.getTime()));
    }

    public static String getDateByFormat(Timestamp timestamp, String format) {
        format = format == null ? DATE_FORMATER : format;
        DateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(timestamp);
    }
}

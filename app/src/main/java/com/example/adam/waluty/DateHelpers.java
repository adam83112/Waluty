package com.example.adam.waluty;


import com.example.adam.waluty.services.FixerClient;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by adam on 14.05.17.
 */

public class DateHelpers {
    private static final  String DATE_FORMAT = "yyyy-MM-dd";

    public static String dateToString(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        return dateFormat.format(date);
    }

    public static Date stringToDate(String date) {
        try {
            DateFormat format = new SimpleDateFormat(DATE_FORMAT);
            return format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date addDays(Date d, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }

    private static boolean isBankHoliday(Date d) {
        Calendar c = new GregorianCalendar();
        c.setTime(d);
        if((Calendar.SATURDAY == c.get(c.DAY_OF_WEEK)) || (Calendar.SUNDAY == c.get(c.DAY_OF_WEEK))) {
            return (true);
        } else {
            return false;
        }
    }

    public static Date lastWorkingDay(Date d) {
        while (isBankHoliday(d)) {
            d = addDays(d, -1);
        }
        return d;
    }
}

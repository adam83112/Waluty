package com.example.adam.waluty;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by adam on 14.05.17.
 */

public class DateHelpers {
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

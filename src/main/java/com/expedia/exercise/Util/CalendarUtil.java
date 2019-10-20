package com.expedia.exercise.Util;

import java.util.Calendar;
import java.util.Date;

public final class CalendarUtil {

    private CalendarUtil(){}

    public static void resetTime(final Calendar calendar) {
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    }

    public static Calendar getClearTimeCalendar(final Date date){
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        resetTime(calendar);
        return calendar;
    }

}

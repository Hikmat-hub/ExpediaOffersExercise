package com.expedia.exercise.Util;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

public class CalendarUtilTest {

    @Test
    public void testResetTime(){
        Calendar calendar = Calendar.getInstance();
        CalendarUtil.resetTime(calendar);
        Assert.assertEquals(0, calendar.get(Calendar.HOUR));
        Assert.assertEquals(0, calendar.get(Calendar.MINUTE));
        Assert.assertEquals(0, calendar.get(Calendar.SECOND));
        Assert.assertEquals(0, calendar.get(Calendar.MILLISECOND));
     }

    @Test
    public void testClearTimeCalendar(){
        Calendar calendarDate = Calendar.getInstance();
        calendarDate.set(Calendar.DATE, 1);
        calendarDate.set(Calendar.MONTH, 2);
        calendarDate.set(Calendar.YEAR, 2011);
        Calendar calendar = CalendarUtil.getClearTimeCalendar(calendarDate.getTime());
        Assert.assertEquals(0, calendar.get(Calendar.HOUR));
        Assert.assertEquals(0, calendar.get(Calendar.MINUTE));
        Assert.assertEquals(0, calendar.get(Calendar.SECOND));
        Assert.assertEquals(0, calendar.get(Calendar.MILLISECOND));
        Assert.assertEquals(1, calendar.get(Calendar.DATE));
        Assert.assertEquals(2, calendar.get(Calendar.MONTH));
        Assert.assertEquals(2011, calendar.get(Calendar.YEAR));
    }
}

package com.example.retrofitdemo.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTimeUtil {

    public static Calendar getCalendarFromFormat(String strCalendar) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date date = null;
        try {
            date = simpleDateFormat.parse(strCalendar);
        }catch (ParseException e){
            e.printStackTrace();
        }
        if(date == null){
            return null;
        }else{
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar;
        }
    }

    public static final String convertFormatRequest(Calendar calendar){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String convert = simpleDateFormat.format(calendar.getTime());
        return convert;
    }
}

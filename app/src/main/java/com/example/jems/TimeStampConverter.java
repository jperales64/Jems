package com.example.jems;

import android.arch.persistence.room.TypeConverter;
import android.provider.SyncStateContract;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TimeStampConverter {
    @TypeConverter
    public static LocalDate toDate(String dateString) {
        if (dateString == null) {
            return null;
        } else {
            return LocalDate.parse(dateString);
        }
    }

    @TypeConverter
    public static String toDateString(LocalDate date) {
        if (date == null) {
            return null;
        } else {
            return date.toString();
        }
    }
//    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
////    static DateFormat df = new SimpleDateFormat(SyncStateContract.Constants.TIME_STAMP_FORMAT);
//    @TypeConverter
//    public static LocalDateTime fromTimestamp(String value) {
//        if (value != null)
//            return LocalDateTime.parse(value, formatter);
//        else
//            return null;
//    }
}

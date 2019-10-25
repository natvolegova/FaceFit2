package com.example.facefit2.Data;

import androidx.room.TypeConverter;

import com.example.facefit2.Data.Constants;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {
    static DateFormat df = new SimpleDateFormat(Constants.DATE_FORMAT);

    @TypeConverter
    public static Date fromTimestamp(String value) {
        if (value != null) {
            try {
                return df.parse(value);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return null;
        } else {
            return null;
        }
    }

    @TypeConverter
    public static String dateToTimestamp(Date value) {

        return value == null ? null : df.format(value);
    }
}

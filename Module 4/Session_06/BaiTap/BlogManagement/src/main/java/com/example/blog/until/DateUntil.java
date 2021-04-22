package com.example.blog.until;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUntil {
    public static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
        Date date = new Date();
        return dateFormat.format(date);
    }
}

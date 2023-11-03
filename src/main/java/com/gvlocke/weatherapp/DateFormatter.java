package com.gvlocke.weatherapp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatter {
    public static String format(String time) {
        LocalDateTime dateTime = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, uuuu - HH:mm");
        return dateTime.format(formatter);
    }
}

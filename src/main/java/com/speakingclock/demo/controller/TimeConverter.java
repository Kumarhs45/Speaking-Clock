package com.speakingclock.demo.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeConverter {
    public static String convertTimeToWords(String time) {
        String[] hours = {
                "Midnight", "One", "Two", "Three", "Four", "Five", "Six",
                "Seven", "Eight", "Nine", "Ten", "Eleven", "Midday"
        };
        String[] minutes = {
                "", "oh one", "oh two", "oh three", "oh four", "oh five", "oh six", "oh seven",
                "oh eight", "oh nine", "ten", "eleven", "twelve", "thirteen", "fourteen",
                "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty",
                "twenty one", "twenty two", "twenty three", "twenty four", "twenty five",
                "twenty six", "twenty seven", "twenty eight", "twenty nine"
        };

        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date;
        try {
            date = dateFormat.parse(time);
        } catch (Exception e) {
            return "Invalid time format.";
        }

        int hour = date.getHours();
        int minute = date.getMinutes();

        if (hour == 0 && minute == 0) {
            return "Midnight";
        } else if (hour == 12 && minute == 0) {
            return "Midday";
        }

        String hourText = (hour > 12) ? hours[hour - 12] : hours[hour];
        String minuteText = (minute == 15) ? "quarter" : (minute == 30) ? "half" : minutes[minute];

        String timeInWords = hourText + " " + minuteText;
        return timeInWords.trim();
    }

    public static void main(String[] args) {
        String time = "08:34";
        String timeInWords = convertTimeToWords(time);
        System.out.println(timeInWords);
    }
}
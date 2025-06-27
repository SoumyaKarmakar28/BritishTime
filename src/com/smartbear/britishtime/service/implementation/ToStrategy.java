package com.smartbear.britishtime.service.implementation;

import com.smartbear.britishtime.service.TimeFormatStrategy;
import com.smartbear.britishtime.util.BritishTimeUtils;

import java.time.LocalTime;

public class ToStrategy implements TimeFormatStrategy {
    private static final String[] HOURS = BritishTimeUtils.HOURS;
    private static final String[] MINUTES = BritishTimeUtils.MINUTES;

    public boolean matches(LocalTime time) {
        int minute = time.getMinute();
        return minute > 30 && minute != 45;
    }

    public String format(LocalTime time) {
        return MINUTES[60 - time.getMinute()] + " to " + HOURS[(time.getHour() + 1) % 12];
    }
}
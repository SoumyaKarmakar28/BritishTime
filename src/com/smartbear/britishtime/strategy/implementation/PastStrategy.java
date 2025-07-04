package com.smartbear.britishtime.strategy.implementation;

import com.smartbear.britishtime.strategy.TimeFormatStrategy;
import com.smartbear.britishtime.util.BritishTimeUtils;

import java.time.LocalTime;

public class PastStrategy implements TimeFormatStrategy {
    private static final String[] HOURS = BritishTimeUtils.HOURS;
    private static final String[] MINUTES = BritishTimeUtils.MINUTES;

    public boolean matches(LocalTime time) {
        int minute = time.getMinute();
        return minute < 30 && minute != 15 && minute != 0;
    }

    public String format(LocalTime time) {
        return MINUTES[time.getMinute()] + " past " + HOURS[time.getHour() % 12];
    }
}

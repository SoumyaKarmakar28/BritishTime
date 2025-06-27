package com.smartbear.britishtime.service.implementation;

import com.smartbear.britishtime.service.TimeFormatStrategy;
import com.smartbear.britishtime.util.BritishTimeUtils;

import java.time.LocalTime;

public class HalfPastStrategy implements TimeFormatStrategy {
    private static final String[] HOURS = BritishTimeUtils.HOURS;

    public boolean matches(LocalTime time) {
        return time.getMinute() == 30;
    }

    public String format(LocalTime time) {
        return "half past " + HOURS[time.getHour() % 12];
    }
}

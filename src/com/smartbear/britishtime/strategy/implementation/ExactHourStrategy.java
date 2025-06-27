package com.smartbear.britishtime.strategy.implementation;

import com.smartbear.britishtime.strategy.TimeFormatStrategy;
import com.smartbear.britishtime.util.BritishTimeUtils;

import java.time.LocalTime;

public class ExactHourStrategy implements TimeFormatStrategy {
    private static final String[] HOURS = BritishTimeUtils.HOURS;

    public boolean matches(LocalTime time) {
        return time.getMinute() == 0;
    }

    public String format(LocalTime time) {
        return HOURS[time.getHour() % 12] + " o'clock";
    }
}
package com.smartbear.britishtime.strategy.implementation;

import com.smartbear.britishtime.strategy.TimeFormatStrategy;
import com.smartbear.britishtime.util.BritishTimeUtils;

import java.time.LocalTime;

public class QuarterToStrategy implements TimeFormatStrategy {
    private static final String[] HOURS = BritishTimeUtils.HOURS;

    public boolean matches(LocalTime time) {
        return time.getMinute() == 45;
    }

    public String format(LocalTime time) {
        return "quarter to " + HOURS[(time.getHour() + 1) % 12];
    }
}
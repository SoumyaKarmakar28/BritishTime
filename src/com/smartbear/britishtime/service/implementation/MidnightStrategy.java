package com.smartbear.britishtime.service.implementation;

import com.smartbear.britishtime.service.TimeFormatStrategy;

import java.time.LocalTime;

public class MidnightStrategy implements TimeFormatStrategy {
    public boolean matches(LocalTime time) {
        return time.getHour() == 0 && time.getMinute() == 0;
    }

    public String format(LocalTime time) {
        return "midnight";
    }
}

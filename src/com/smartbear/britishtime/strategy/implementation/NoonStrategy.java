package com.smartbear.britishtime.strategy.implementation;

import com.smartbear.britishtime.strategy.TimeFormatStrategy;

import java.time.LocalTime;

public class NoonStrategy implements TimeFormatStrategy {
    public boolean matches(LocalTime time) {
        return time.getHour() == 12 && time.getMinute() == 0;
    }

    public String format(LocalTime time) {
        return "noon";
    }
}

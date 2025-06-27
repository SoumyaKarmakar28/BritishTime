package com.smartbear.britishtime.strategy;

import java.time.LocalTime;

public interface TimeFormatStrategy {
    boolean matches(LocalTime time);
    String format(LocalTime time);
}

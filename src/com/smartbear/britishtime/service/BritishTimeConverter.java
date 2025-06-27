package com.smartbear.britishtime.service;

import com.smartbear.britishtime.exception.InvalidTimeFormatException;
import com.smartbear.britishtime.strategy.TimeFormatStrategy;
import com.smartbear.britishtime.factory.TimeFormatStrategyFactory;

import java.time.LocalTime;

public class BritishTimeConverter {
    private final TimeParser timeParser = new TimeParser();
    private final TimeFormatStrategyFactory strategyFactory = new TimeFormatStrategyFactory();

    public String toSpokenTime(String timeStr) throws InvalidTimeFormatException {
        LocalTime time = timeParser.parse(timeStr);
        TimeFormatStrategy strategy = strategyFactory.getStrategy(time);
        return strategy.format(time);
    }
}

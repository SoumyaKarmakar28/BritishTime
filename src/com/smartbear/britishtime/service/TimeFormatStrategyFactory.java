package com.smartbear.britishtime.service;

import com.smartbear.britishtime.service.implementation.*;

import java.time.LocalTime;
import java.util.List;
public class TimeFormatStrategyFactory {
    private final List<TimeFormatStrategy> strategies = List.of(
            new MidnightStrategy(),
            new NoonStrategy(),
            new ExactHourStrategy(),
            new QuarterPastStrategy(),
            new HalfPastStrategy(),
            new QuarterToStrategy(),
            new PastStrategy(),
            new ToStrategy()
    );

    public TimeFormatStrategy getStrategy(LocalTime time) {
        return strategies.stream()
                .filter(strategy -> strategy.matches(time))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No matching strategy found"));
    }
}

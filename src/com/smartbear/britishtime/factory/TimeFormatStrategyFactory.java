package com.smartbear.britishtime.factory;

import com.smartbear.britishtime.strategy.TimeFormatStrategy;
import com.smartbear.britishtime.strategy.implementation.*;

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

package com.smartbear.britishtime.service;

import com.smartbear.britishtime.exception.InvalidTimeFormatException;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TimeParser {
    public LocalTime parse(String timeStr) throws InvalidTimeFormatException {
        try {
            return LocalTime.parse(timeStr, DateTimeFormatter.ofPattern("HH:mm"));
        } catch (DateTimeParseException e) {
            throw new InvalidTimeFormatException("Invalid input format. Please use HH:mm (04:05).", e);
        }
    }
}
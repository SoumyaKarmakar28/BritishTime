package com.smartbear.britishtimeTest;

import com.smartbear.britishtime.exception.InvalidTimeFormatException;
import com.smartbear.britishtime.service.BritishTimeConverter;

public class TestRunner {
    public static void main(String[] args) {
        BritishTimeConverter converter = new BritishTimeConverter();

        test("00:00", "midnight", converter);
        test("12:00", "noon", converter);
        test("01:00", "one o'clock", converter);
        test("02:15", "quarter past two", converter);
        test("03:30", "half past three", converter);
        test("04:45", "quarter to five", converter);
        test("05:05", "five past five", converter);
        test("06:25", "twenty-five past six", converter);
        test("07:40", "twenty to eight", converter);
        test("08:50", "ten to nine", converter);

        testInvalid("24:99", converter);
        testInvalid("abcd", converter);
        testInvalid("99:99", converter);
    }

    private static void test(String input, String expected, BritishTimeConverter converter) {
        try {
            String result = converter.toSpokenTime(input);
            if (result.equals(expected)) {
                System.out.println("[PASS] " + input + " => " + result);
            } else {
                System.out.println("[FAIL] " + input + " => Expected: " + expected + ", but got: " + result);
            }
        } catch (Exception e) {
            System.out.println("[FAIL] " + input + " => Unexpected Exception: " + e.getMessage());
        }
    }

    private static void testInvalid(String input, BritishTimeConverter converter) {
        try {
            converter.toSpokenTime(input);
            System.out.println("[FAIL] " + input + " => Expected failure, but conversion succeeded");
        } catch (InvalidTimeFormatException e) {
            System.out.println("[PASS] " + input + " => Correctly threw InvalidTimeFormatException");
        } catch (Exception e) {
            System.out.println("[FAIL] " + input + " => Unexpected Exception Type: " + e.getClass().getSimpleName());
        }
    }
}

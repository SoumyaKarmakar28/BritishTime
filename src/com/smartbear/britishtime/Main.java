package com.smartbear.britishtime;

import com.smartbear.britishtime.exception.InvalidTimeFormatException;
import com.smartbear.britishtime.service.BritishTimeConverter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BritishTimeConverter converter = new BritishTimeConverter();

        System.out.print("Enter time in HH:mm format: ");
        String input = scanner.nextLine();

        try {
            String spokenTime = converter.toSpokenTime(input);
            System.out.println("Spoken Time: " + spokenTime);
        } catch (InvalidTimeFormatException e) {
            System.err.println(e.getMessage());
        } catch (Exception e){
            System.err.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

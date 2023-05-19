package org.example.homework.thirteenth;

import lombok.extern.slf4j.Slf4j;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


@Slf4j
public class ThirteenthHomeTask {
    public static void main(String[] args) {

        getDayOfWeekByInputtedDate();
        getNextTuesday();
        firstTask();
        secondTask();

    }

    private static void getDayOfWeekByInputtedDate() {

        try (Scanner sc = new Scanner(System.in)) {
            log.info("Enter the day");
            int day = Integer.parseInt(sc.nextLine());
            log.info("Enter the month");
            int month = Integer.parseInt(sc.nextLine());
            log.info("Enter the year");
            int year = Integer.parseInt(sc.nextLine());

            LocalDate date = LocalDate.of(year, month, day);

            log.info("This day is - {}", date.getDayOfWeek());
        } catch (DateTimeException e) {
            log.info("This date is invalid, try again {}", e);
        }
    }

    private static void getNextTuesday() {
        LocalDate date = LocalDate.now();
        log.info("Date of next tuesday is: {}",  date.with(TemporalAdjusters.next(DayOfWeek.TUESDAY)));
    }

    private static void firstTask() {
        Predicate<Integer> exactDividing = (number) -> number % 13 == 0;

        Consumer<Integer> squareNumber = (x) -> {
            if (x < 0) {
                log.info("This number is negative - '{}'", x);
                return;
            }
            log.info("Square of this number -  {}", x * x);
        };

        Function<String, Integer> calculateWords = (string) -> {
            String[] splittedString = string.split(" ");
            return splittedString.length;
        };

    }

    private static void secondTask() {
        Function<String, Integer> highCaseLetters = (string) -> {

            int counter = 0;

            for (int i = 0; i < string.length(); i++) {

                int ch = string.charAt(i);
                if (ch >= 128 && ch <= 159 || ch >= 65 && ch <= 90) {
                    counter++;
                }
            }

            return counter;
        };

        ReturnLongerString smth = (first, second) -> {
            if (first.length() > second.length()) {
                return first;
            } else return second;
        };

        System.out.println(smth.returnLongerString("ab", "asc"));

    }
}


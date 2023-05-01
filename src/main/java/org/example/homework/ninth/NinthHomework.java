package org.example.homework.ninth;


import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class NinthHomework {

    public static void main(String[] args) {

        callMethodsForMainTask();
        findLongestWord();
        findMinimalSymbolsEntry();
        doubleChar();

        try {
            boolean res = checkPalindrome(500);
            log.info("This word is palindrome? {}", res);
        }
        catch (Exception e){
            log.info(e.getMessage());
        }

    }

    private static void callMethodsForMainTask() {

        MainTask.printNumbersBlock();
        MainTask.replaceChars();
        MainTask.printStringLowCase();
        MainTask.printStringHighCase();
        MainTask.isContainsSubstring();
        MainTask.isContainsNumberSequence();
        MainTask.isEndsWithSubstring();

    }

    private static void findLongestWord() {
        String tempString = " asda qwe 123 3 21 31 assw";

        String result = Arrays.stream(tempString.split(" "))
                .sorted(Comparator.comparingInt(String::length))
                .reduce((first, second) -> second)
                .orElse(null);

        log.info("word: {}", result);

    }

    private static void findMinimalSymbolsEntry() {
        String tempString = "f213ffff ggggg fffffff ab f 1234 jkjk";

        Map<String, Integer> tempMap = new LinkedHashMap<>();

        Arrays.stream(tempString.split(" "))
                .forEach((string) -> tempMap.put(string,
                        Arrays.stream(string.split(""))
                                .map(String::toLowerCase)
                                .collect(Collectors.groupingBy(s -> s, HashMap::new, Collectors.counting()))
                                .entrySet()
                                .size()));

        String result = tempMap.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .orElseThrow()
                .getKey();

        log.info("Fist string with satisfying conditions: {}", result);
    }

    private static void doubleChar() {
        String tempString = "Hello";

        String result = Arrays.stream(tempString.split(""))
                .map((element) -> element + element)
                .collect(Collectors.joining());

        log.info("New word: {}", result);
    }

    private static boolean checkPalindrome(int wordPosition) throws NoSuchElementException{
        String tempString = "mem mummy shit loh";

        String[] s = tempString.split(" ");

        if (wordPosition > s.length) {
            throw new NoSuchElementException("Invalid word position is selected");
        }

        String word = s[wordPosition];

        return word.contentEquals(new StringBuilder(word).reverse());

    }
}
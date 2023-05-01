package org.example.homework.ninth;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainTask {

    private static final String initialString = "5555-sss-5555-sss-5s5s";

    static void printNumbersBlock() {
        StringBuilder tempString = new StringBuilder();
        int counterOfEntries = 0;

        for (int i = 0, size = initialString.length(); i < size; i++) {
            if (initialString.charAt(i) == '5') {
                counterOfEntries++;
            }
            if (counterOfEntries == 4) {
                tempString.append("5555");
                counterOfEntries = 0;
            }

        }
        tempString.insert(4, "-");

        log.info("String with numbers block is: {}", tempString);

    }

    static void replaceChars() {
        StringBuilder tempString = new StringBuilder(initialString);
        int counterOfEntries = 0;

        for (int i = 0, size = tempString.length(); i < size; i++) {
            if (tempString.charAt(i) == 's') {
                counterOfEntries++;
            }
            if (counterOfEntries == 3) {
                tempString.replace(i - 2, i + 1, "***");
                counterOfEntries = 0;
            }
        }

        log.info("Replaced string is: {}", tempString);
    }

    static void printStringLowCase() {
        StringBuilder tempString = new StringBuilder();

        for (int i = 0, size = initialString.length(); i < size; i++) {
            if (initialString.charAt(i) == 's') {
                tempString.append(initialString.charAt(i));
            }
        }

        tempString.insert(0, "Letters: ");
        tempString.insert(12, "/");
        tempString.insert(16, "/");
        tempString.insert(18, "/");
        tempString.insert(20, "/");

        log.info("{}", tempString);
    }

    static void printStringHighCase() {
        StringBuilder tempString = new StringBuilder();

        for (int i = 0, size = initialString.length(); i < size; i++) {
            if (initialString.charAt(i) == 's') {
                tempString.append(initialString.toUpperCase().charAt(i));
            }
        }

        tempString.insert(0, "Letters: ");
        tempString.insert(12, "/");
        tempString.insert(16, "/");
        tempString.insert(18, "/");
        tempString.insert(20, "/");

        log.info("{}", tempString);
    }

    static void isContainsSubstring() {

        if (initialString.contains("abc") || initialString.contains("ABC")) {
            log.info("This string contains this char sequence");
        } else {
            log.info("This string doesn't contains this char sequence");
        }
    }

    static void isContainsNumberSequence() {

        if (initialString.startsWith("555")) {
            log.info("This string starts with number sequence");
        } else {
            log.info("This string doesn't starts with number sequence");
        }
    }

    static void isEndsWithSubstring() {
        if (initialString.endsWith("1a2b")) {
            log.info("This string ends with this sequence");
        } else {
            log.info("This string doesn't ends with this sequence");
        }
    }
}

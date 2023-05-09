package org.example.homework.ninth;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainTask {

    private static final String templateString = "5555-sss-5555-sss-5s5s";
    private static String numberDoc;


    static void initializeString(int number, char letter) {
        StringBuilder tempBuilder = new StringBuilder();

        for (int i = 0; i < 2; i++) {
            tempBuilder.append(number);
            tempBuilder.append(number);
            tempBuilder.append(number);
            tempBuilder.append(number);
            tempBuilder.append("-");
            tempBuilder.append(letter);
            tempBuilder.append(letter);
            tempBuilder.append(letter);
            tempBuilder.append("-");
        }

        tempBuilder.append(number);
        tempBuilder.append(letter);
        tempBuilder.append(number);
        tempBuilder.append(letter);

        numberDoc = tempBuilder.toString();
    }

    static void printNumbersBlock() {
        StringBuilder tempString = new StringBuilder();
        int counterOfEntries = 0;

        int ascii;
        char number = numberDoc.charAt(0);

        for (int i = 0, size = numberDoc.length(); i < size; i++) {
            ascii = numberDoc.charAt(i);
            if (ascii >= 48 && ascii <= 57) {
                counterOfEntries++;
            }
            if (counterOfEntries == 4) {
                tempString.append(number);
                tempString.append(number);
                tempString.append(number);
                tempString.append(number);
                counterOfEntries = 0;
            }

        }
        tempString.insert(4, "-");

        log.info("String with numbers block is: {}", tempString);

    }

    static void replaceChars() {
        StringBuilder tempString = new StringBuilder(numberDoc);
        int counterOfEntries = 0;
        int ascii;

        for (int i = 0, size = tempString.length(); i < size; i++) {

            ascii = numberDoc.charAt(i);

            if (isLetter(ascii)) {   //проверка на заглавные и строчные буквы
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
        int ascii;

        for (int i = 0, size = numberDoc.length(); i < size; i++) {
            ascii = numberDoc.charAt(i);

            if (isLetter(ascii)) {
                tempString.append(numberDoc.charAt(i));
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
        int ascii;

        for (int i = 0, size = numberDoc.length(); i < size; i++) {
            ascii = numberDoc.charAt(i);

            if (isLetter(ascii)) {
                tempString.append(numberDoc.toUpperCase().charAt(i));
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

        if (numberDoc.contains("abc") || numberDoc.contains("ABC")) {
            log.info("This string contains this char sequence");
        } else {
            log.info("This string doesn't contains this char sequence");
        }
    }

    static void isContainsNumberSequence() {

        if (numberDoc.startsWith("555")) {
            log.info("This string starts with number sequence");
        } else {
            log.info("This string doesn't starts with number sequence");
        }
    }

    static void isEndsWithSubstring() {
        if (numberDoc.endsWith("1a2b")) {
            log.info("This string ends with this sequence");
        } else {
            log.info("This string doesn't ends with this sequence");
        }
    }

    private static boolean isLetter(int ascii) {
        return ascii >= 65 && ascii <= 90 || ascii >= 97 && ascii <= 122;
    }
}

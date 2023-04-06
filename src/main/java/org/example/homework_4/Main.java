package org.example.homework_4;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidNumberException, LoserException {

        int optionNumber = returnDataFromScanner("Set a number from range [1..8]");

        while (true) {
            switch (optionNumber) {
                case 1 -> printColorOfRainbow();
                case 2 -> calculateNumbersFromUser();
                case 3 -> printSomeNumbers();
                case 4 -> predictRandomNumber();
                case 5 -> printDiffOriNumbers();
                case 6 -> printSquaresOfNumbers();
                case 7 -> calculateBankIncome();
                case 8 -> printMultiplicationTable();
                case 0 -> {
                    return;
                }
                default -> throw new InvalidNumberException("\"You are setting a invalid number.\" +\n" +
                        "                        \" Only numbers from range [1..8] is allowed.\" +\n");
            }
        }
    }

    private static void printColorOfRainbow() throws InvalidNumberException {

        int rainbowColorNumber = returnDataFromScanner("Set a number from range [1..7]");

        switch (rainbowColorNumber) {
            case 1 -> System.out.println("It is a red color!");
            case 2 -> System.out.println("It is a orange color!");
            case 3 -> System.out.println("It is a yellow color!");
            case 4 -> System.out.println("It is a green color!");
            case 5 -> System.out.println("It is a blue color!");
            case 6 -> System.out.println("It is a indigo color!");
            case 7 -> System.out.println("It is a violet color!");
            default -> {
                throw new InvalidNumberException("\"You are setting a invalid number.\" +\n" +
                        "                        \" Only numbers from range [1..7] is allowed.\" +\n" +
                        "                        \" Try again.\"");
            }
        }
    }

    private static int returnDataFromScanner(String request){
        System.out.println(request);
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }

    private static void calculateNumbersFromUser() throws InvalidNumberException {

        int userNumber = returnDataFromScanner("Set a number from range [1..100]");

        if (userNumber > 100 || userNumber < 0) {
            throw new InvalidNumberException("Only numbers above 0 and below 100 is allowed");
        } else {

            System.out.println("The sum of your numbers is equal to: " + userNumber*(userNumber+1)/2);
        }
    }

    private static void printSomeNumbers() {
        for (int i = 7; i < 100; i += 7) {
            System.out.println("Number: " + i);
        }
    }

    private static void predictRandomNumber() throws LoserException {
        Random random = new Random();

        int number = random.nextInt(10);
        int amountOfTries = 6;
        int userNumber;

        for (int i = 0; i < amountOfTries; i++) {
            userNumber = returnDataFromScanner("Print a number, my dear friend: ");

            if (userNumber == number) {
                System.out.println("U are winner!");
                return;
            } else {
                System.out.println("Try again." + "\n");
            }
        }
        throw new LoserException("U are loser. Our algorithms are better than your luck, fool.");
    }

    private static void printDiffOriNumbers() {
        for (int i = 0; i < 20; i += 2) {
            System.out.println("Number " + i * 5);
            System.out.println("Number " + (i + 1) * 5 * -1);
        }
    }

    private static void printSquaresOfNumbers() {
        for (int i = 10; i <= 20; i++) {
            System.out.println("Squares of number " + i + " is: " + i*i);
        }
    }

    private static void calculateBankIncome() {

        int amountOfMoney = returnDataFromScanner("Enter the amount of your money for a bank deposit: ");
        int amountOfMonth = returnDataFromScanner("Enter the desirable amount of month for your  bank deposit: ");

        float percentOfIncome = 0.07f;

        for (int i = 1; i <= amountOfMonth; i++) {
            System.out.println("Current amount of money of " + i + " is : " + (amountOfMoney * percentOfIncome * i + amountOfMoney) + " bucks");
        }
        System.out.println(" Wow, your bank deposit is effective! TY for your trust shown! <3 ");
    }

    private static void printMultiplicationTable() {
        System.out.println(" ");

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.println("Multiplication of " + i + " and " + j + " is equal to: " + i * j + " ");
            }
            System.out.println(" ");
        }
    }

}
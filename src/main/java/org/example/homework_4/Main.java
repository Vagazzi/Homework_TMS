package org.example.homework_4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        int[] intArray = new int[5];
//        int[] firstArrayForComparing = new int[5];
//        int[] secondArrayForComparing = new int[5];
//
//        fillArray(intArray, 30);
//        fillArray(firstArrayForComparing, 30);
//        fillArray(secondArrayForComparing, 30);
//
//        checkNumberIntoTheArray(intArray);
//        replaceNumberFromArray(intArray);
//        printInfoAboutArrayData();
//
//        calculateAvgSumOfArrays(firstArrayForComparing,secondArrayForComparing);
//        printEvenNumbers();
//
//        printArrayWithZeros();

//        searchMostFrequentNumber();

        calcWeightWatermelons(5d, 2d, 4, 2);
    }

    private static int[] fillArray(int[] array, int bound) {
        Random random = new Random(1);

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(bound);
        }

        return array;
    }

    private static void checkNumberIntoTheArray(int[] array) {

        printArray(array, "Initial array: ");

        int searchableNumber = returnNumberFromScanner("Enter the  searchable number");
        boolean isExisting = false;

        for (int j : array) {
            if (j == searchableNumber) {
                isExisting = true;
                break;
            }
        }

        if (isExisting) {
            System.out.println("\nYour number is existing into this array\n");
        } else {
            System.out.println("\nYour number is not existing into this array\n");
        }

    }

    private static void replaceNumberFromArray(int[] array) {

        printArray(array, "Initial array: ");

        int replaceableNumber = returnNumberFromScanner("Enter the replaceable number");

        for (int i = 0; i < array.length; i++) {
            if (array[i] == replaceableNumber) {
                array[i] = 0;
            }
        }

        printArray(array, "\nArray after changes: \n");
    }

    private static void printInfoAboutArrayData() {
        int sizeOfArray = returnNumberFromScanner("Enter the size of array");

        int[] pseudoDynamicArray = new int[sizeOfArray];
        fillArray(pseudoDynamicArray, 30);
        printArray(pseudoDynamicArray, "Your array is: ");

        int minValue = pseudoDynamicArray[0];
        int maxValue = pseudoDynamicArray[0];

        float avgValue = 0.0f;

        for (int j : pseudoDynamicArray) {
            avgValue += j;
            if (j < minValue) {
                minValue = j;
            }
            if (j > maxValue) {
                maxValue = j;
            }
        }


        System.out.println("The minimal element in this array is: " + minValue + ", maximal element is " + maxValue + ", and average sum is " + avgValue / pseudoDynamicArray.length);

    }

    private static void calculateAvgSumOfArrays(int[] firstArray, int[] secondArray) {

        float avgSumElementsFirstArray = 0;
        float avgSumElementSecondArray = 0;

        for (int i = 0; i < 5; i++) {
            avgSumElementsFirstArray += firstArray[i];
            avgSumElementSecondArray += secondArray[i];
        }

        avgSumElementsFirstArray /= 5;
        avgSumElementSecondArray /= 5;


        if (avgSumElementsFirstArray > avgSumElementSecondArray) {
            System.out.println("The sum of elements of the first array is more than in the second");
        } else if (avgSumElementsFirstArray == avgSumElementSecondArray) {
            System.out.println("The sum of elements is equal into the both elements");
        } else {
            System.out.println("The sum of elements of the second array is more than in the first");
        }
        System.out.println(avgSumElementsFirstArray + " and " + avgSumElementSecondArray);
    }

    // Согласен, что решение не самое изящное, но если исходить из того, что по условию коллекций не существует, то оно, в принципе, имеет право на существование.
    private static void printEvenNumbers() {

        int sizeOfArray;

        do {
            sizeOfArray = returnNumberFromScanner("Enter the size of your array in range [5..10]");

            System.out.println("Your array size is not satisfy the condition. Try again. \n");
        } while (sizeOfArray < 5 || sizeOfArray > 10);

        int[] array = new int[sizeOfArray];

        fillArray(array, 30);

        printArray(array, "Your array is: ");

        int countOfEvenElement = 0;

        for (int value : array) {
            if (value % 2 == 0) {
                countOfEvenElement++;
            }
        }

        int[] evenElementArray = new int[countOfEvenElement];
        int j = 0;

        for (int k : array) {

            if (k % 2 == 0) {

                evenElementArray[j] = k;
                j++;

            }
        }

        printArray(evenElementArray, "New array has " + countOfEvenElement + " element(s) and has these elements: \n");

    }

    private static void printArrayWithZeros() {

        int sizeOfArray = returnNumberFromScanner("Enter the size of array: ");
        int[] array = new int[sizeOfArray];

        printArray(array, "Initial array is: ");

        fillArray(array, 30);

        for (int i = 1; i < array.length; i += 2) {
            array[i] = 0;
        }

        printArray(array, "Changed array is: ");
    }

    // Эх, вот бы коллекции, а не вот это вот всё.
    private static void searchMostFrequentNumber() {
        int[] array = new int[10];

        fillArray(array, 10);

        printArray(array, "Your array: ");

        int maxFrequency = 1;
        int mostFrequentNumber = array[0];


        for (int i = 0; i < array.length - 1; i++) {

            int initalFrequency = 1;

            for (int j = i + 1; j < array.length; j++) {

                if (array[i] == array[j]) {
                    initalFrequency += 1;
                }
                if (initalFrequency > maxFrequency) {
                    maxFrequency = initalFrequency;
                    mostFrequentNumber = array[i];
                }
            }
        }
        if (maxFrequency > 1) {
            System.out.println("Number " + mostFrequentNumber + " occurs " + maxFrequency + " times");
        } else {
            System.out.println("All numbers is unique in this array");
        }
    }

    private static void calcWeightWatermelons(double firstWeight, double lastWeight, double countOfWatermelons, int waterMelonOfInterest) {

        double[] array = new double[(int) countOfWatermelons];

        array[0] = firstWeight;
        array[array.length - 1] = lastWeight;

        double progress = (lastWeight - firstWeight) / array.length;

        for (int i = 0; i < array.length; i++) {
            array[i] = firstWeight + progress * i;
        }

        System.out.println(Arrays.toString(array));

        System.out.println("Interesting watermelon weights " + array[waterMelonOfInterest]);

    }

    private static void printArray(int[] array, String arrayMessage) {

        System.out.println(arrayMessage);
        System.out.println(Arrays.toString(array));

    }


    private static int returnNumberFromScanner(String message) {

        System.out.println(message);
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
    }

}
package org.example.homework_4;

import java.util.Arrays;
import java.util.Random;

public class FourthHomework {
    public static void main(String[] args) {

//        incrementArray();
        printChessBoard();
//        multiplyArrays();
//        calcSumArray();
//        printDiagonals();
//        sortArray();

    }

    private static void incrementArray() {
        int[][][] array = new int[10][10][10];

        int value = 10;

        for (int[][] intArray : array) {
            for (int[] anInt : intArray) {
                Arrays.fill(anInt, value);
            }
        }

        for (int[][] intArray : array) {
            for (int[] anInt : intArray) {
                Arrays.fill(anInt, value * 2);
            }
        }

        System.out.println(Arrays.deepToString(array));
    }

    // ХЗ, насколько это улучшило производительность, но тем не менее, гыг)))0)0
    private static void printChessBoard() {

        String[][] chessBoard = new String[8][8];

        String[][] copyRow = new String[][] {{"W","B","W","B", "W" , "B", "W", "B"}, {"B","W","B","W", "B" , "W", "B", "W"}};

        for (int i = 0; i < chessBoard.length; i+=2) {

               chessBoard[i] = copyRow[0].clone();
               chessBoard[i+1] = copyRow[1].clone();

        }

        for (String[] strings : chessBoard) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
        System.out.println();

    }

    private static void multiplyArrays() {

        int[][] firstArray = new int[3][3];
        int[][] secondArray = new int[3][3];
        int[][] resultArray = new int[3][3];

        fillArrayWithRandomNumbers(firstArray);
        fillArrayWithRandomNumbers(secondArray);

        printArray("Result array: ", firstArray);
        printArray("Result array: ", secondArray);

        for (int i = 0; i < secondArray.length; i++) {
            for (int j = 0; j < secondArray[i].length; j++) {
                resultArray[i][j] = firstArray[i][j] * secondArray[i][j];
            }
        }

        printArray("Result array: ", resultArray);
    }

    private static void calcSumArray() {

        int[][] array = new int[5][5];
        int result = 0;

        fillArrayWithRandomNumbers(array);

        printArray("Generated array: ", array);

        for (int[] ints : array) {
            for (int anInt : ints) {
                result += anInt;
            }
        }

        System.out.println("Result of sum all elements in this array is: " + result);
    }

    private static void printArray(String message, int[][] array) {

        System.out.println();
        System.out.println(message);

        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int[][] fillArrayWithRandomNumbers(int [][] array){

        Random randomFill = new Random();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = randomFill.nextInt(15);
            }
        }

        return array;
    }

    private static void printDiagonals(){
        int [][] array = new int[5][5];
        fillArrayWithRandomNumbers(array);

        printArray("Generated array:", array);

        for (int i = 0; i < array.length; i++){
            System.out.println("Elements of master diagonal: " + array[i][i]);
        }

        System.out.println(" ");

        for (int i = 0; i < array.length; i++){
            System.out.println("Elements of slave diagonal: " + array[i][array.length - 1 - i]);
        }
    }

    private static void sortArray(){
        int [][] array = new int[5][5];

        fillArrayWithRandomNumbers(array);

        printArray("Generated array: ", array);

        for (int[] ints : array) {
            Arrays.sort(ints);
        }

        printArray("Sorted array: ", array);
    }
}

package org.example.homework.fifth;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class ATM {

    private int amountOfTwentyBucksBill;
    private int amountOfFiftyBucksBill;
    private int amountOfOneHundredBucksBill;

    private final int oneHundredBucks = 100;
    private final int fiftyBucks = 50;
    private final int twentyBucks = 20;

    public void withdrawMoney(int sumForWithdraw) {

        int[] values = {twentyBucks, fiftyBucks, oneHundredBucks};
        int[] amounts = {amountOfTwentyBucksBill, amountOfFiftyBucksBill, amountOfOneHundredBucksBill};

        if (sumForWithdraw < 20 || sumForWithdraw % 10 != 0) {
            System.out.println("Input the correct value of withdrawal money");
            return;
        }

        List<Integer[]> results = solutions(values, amounts, new int[3], sumForWithdraw, 0);

        System.out.println("You can get your money by these methods:");
        System.out.println("          20, 50, 100");
        for (int i = 0, counter = 1; i < results.toArray().length; i++, counter++) {

            System.out.println("Method "  + counter + ": " + Arrays.toString(results.get(i)));
        }

    }

    public static List<Integer[]> solutions(int[] values, int[] amounts, int[] variation, int price, int position) {
        ArrayList<Integer[]> list = new ArrayList<>();
        int value = compute(values, variation);

        if (value < price) {
            for (int i = position; i < values.length; i++) {
                if (amounts[i] > variation[i]) {
                    int[] newVariation = variation.clone();
                    newVariation[i]++;
                    List<Integer[]> newList = solutions(values, amounts, newVariation, price, i);
                    if (newList != null) {
                        list.addAll(newList);
                    }
                }
            }
        } else if (value == price) {
            list.add(myCopy(variation));
        }
        return list;
    }

    public static int compute(int[] values, int[] variation) {
        int ret = 0;
        for (int i = 0; i < variation.length; i++) {
            ret += values[i] * variation[i];
        }
        return ret;
    }

    public static Integer[] myCopy(int[] ar) {
        Integer[] ret = new Integer[ar.length];
        for (int i = 0; i < ar.length; i++) {
            ret[i] = ar[i];
        }
        return ret;
    }

    public void printInfoAboutBills() {
        System.out.println("-------------------------------------------------");
        System.out.println("Count of twenty bucks bill is: " + amountOfTwentyBucksBill + ".");
        System.out.println("Count of fifty bucks bill is: " + amountOfFiftyBucksBill + ".");
        System.out.println("Count of one hundred bucks bill is: " + amountOfOneHundredBucksBill + ".");
        System.out.println("-------------------------------------------------");
    }
}

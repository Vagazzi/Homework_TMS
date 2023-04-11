package org.example.homework.fifth;

public class ATM {
    private final int twentyBucks = 20;
    private final int fiftyBucks = 50;
    private final int oneHundredBucks = 100;

    private int amountOfTwentyBucksBill;
    private int amountOfFiftyBucksBill;
    private int amountOfOneHundredBucksBill;

    public ATM(int amountOfTwentyBucksBill, int amountOfFiftyBucksBill, int amountOfOneHundredBucksBill) {
        this.amountOfTwentyBucksBill = amountOfTwentyBucksBill;
        this.amountOfFiftyBucksBill = amountOfFiftyBucksBill;
        this.amountOfOneHundredBucksBill = amountOfOneHundredBucksBill;
    }

    public boolean withdrawMoney(int initialAmountOfMoneyForWithdraw) {

        if (initialAmountOfMoneyForWithdraw > 5000) {
            System.out.println("Value is too big, i can't complete your request.");
            return Status.STATUS_NOT;
        }

        if (initialAmountOfMoneyForWithdraw == twentyBucks || initialAmountOfMoneyForWithdraw == fiftyBucks || initialAmountOfMoneyForWithdraw == oneHundredBucks) {
            System.out.println("This operation is possible, take your bill: " + initialAmountOfMoneyForWithdraw);

            if (initialAmountOfMoneyForWithdraw == twentyBucks) {
                amountOfTwentyBucksBill--;
                initialAmountOfMoneyForWithdraw = 0;
            }

            if (initialAmountOfMoneyForWithdraw == fiftyBucks) {
                amountOfFiftyBucksBill--;
                initialAmountOfMoneyForWithdraw = 0;
            }

            if (initialAmountOfMoneyForWithdraw == oneHundredBucks) {
                amountOfOneHundredBucksBill--;
                initialAmountOfMoneyForWithdraw = 0;
            }

            return Status.STATUS_OK;
        } else if (initialAmountOfMoneyForWithdraw > 100 && initialAmountOfMoneyForWithdraw % 10 == 0) {
            initialAmountOfMoneyForWithdraw -= 100;
            amountOfOneHundredBucksBill--;
            System.out.println("You got a one hundred bucks bill, plz take it");
            withdrawMoney(initialAmountOfMoneyForWithdraw);
        } else if (initialAmountOfMoneyForWithdraw > 50 && initialAmountOfMoneyForWithdraw % 10 == 0) {
            initialAmountOfMoneyForWithdraw -= 50;
            amountOfFiftyBucksBill--;
            System.out.println("You got a one fifty bucks bill, plz take it");
            withdrawMoney(initialAmountOfMoneyForWithdraw);
        } else if (initialAmountOfMoneyForWithdraw > 20 && initialAmountOfMoneyForWithdraw % 10 == 0) {
            initialAmountOfMoneyForWithdraw -= 20;
            amountOfTwentyBucksBill--;
            System.out.println("You got a one twenty bucks bill, plz take it");
            withdrawMoney(initialAmountOfMoneyForWithdraw);
        } else {
            System.out.println("This operation is impossible, please, set the correct amount of money.");
            return Status.STATUS_NOT;
        }

        return Status.STATUS_OK;
    }

    public void printInfoAboutBills() {
        System.out.println("-------------------------------------------------");
        System.out.println("Count of twenty bucks bill is: " + amountOfTwentyBucksBill + ".");
        System.out.println("Count of fifty bucks bill is: " + amountOfFiftyBucksBill + ".");
        System.out.println("Count of one hundred bucks bill is: " + amountOfOneHundredBucksBill + ".");
        System.out.println("-------------------------------------------------");
    }
}

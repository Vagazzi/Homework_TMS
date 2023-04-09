package org.example.homework.fifth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CreditCard {

    private String accountNumber;
    private double amountOfMoney;


    public void putMoneyOnTheAccount(int amountOfMoney) {
        this.amountOfMoney += amountOfMoney;
        System.out.println("Finance income: " + amountOfMoney + " bucks. Your current balance is: " + this.amountOfMoney + " bucks.");
    }

    public void withdrawMoney(int amountOfMoney) {
        if (this.amountOfMoney > 0 && this.amountOfMoney >= amountOfMoney) {
            this.amountOfMoney -= amountOfMoney;
            System.out.println("You have withdraw " + amountOfMoney + " bucks. Your current balance is: " + this.amountOfMoney + " bucks.");
        } else {
            System.out.println("Your balance is not enough to carry out this transaction.");
        }
    }

    public void getInfoAboutAccount (){
        System.out.println("--------------------");
        System.out.println("Account number is: " + this.accountNumber);
        System.out.println("Amount of money on this account is: " + this.amountOfMoney);
        System.out.println("--------------------");
    }
}

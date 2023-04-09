package org.example.homework.fifth;

public class HomeTaskFifth {
    public static void main(String[] args) {
        createSomePC();
        creditCardTransactions();
        withdrawMoney();
    }

    private static void creditCardTransactions() {

        CreditCard myOwnSalaryCard = new CreditCard("1477632", 1000.32);
        CreditCard myWifeSalaryCard = new CreditCard("1477633", 800.47);
        CreditCard myPensionCard = new CreditCard("1477634", 400.88);

        myWifeSalaryCard.putMoneyOnTheAccount(1000);
        myWifeSalaryCard.getInfoAboutAccount();

        myOwnSalaryCard.putMoneyOnTheAccount(100000);
        myOwnSalaryCard.getInfoAboutAccount();

        myPensionCard.withdrawMoney(1000000);
        myPensionCard.withdrawMoney(40);
        myPensionCard.getInfoAboutAccount();

    }

    private static void createSomePC() {

        PC pcFirst = new PC("dream pc", 300.00d);

        HDD hddStorage = new HDD("Seagate", 1024, TypeOfStorage.Internal.toString());
        RAM ramStick = new RAM("G. Skill Royal Gold", 32);
        PC pcSecond = new PC(hddStorage, ramStick, "shit pc", 999999.99);

        System.out.println(pcFirst);
        System.out.println(pcSecond);

    }

    private static void withdrawMoney() {
        ATM atm = new ATM(1000, 1000, 1000);

        atm.withdrawMoney(190);
        atm.printInfoAboutBills();

        atm.withdrawMoney(-1203123);

    }

}

package org.example.homework.seventh;

import org.example.homework.seventh.firstTask.Phone;
import org.example.homework.seventh.secondTask.patient.Patient;

public class SeventhHomework {
    public static void main(String[] args) {
//        simulatePhone();
          simulatePolyclinic();
    }

    private static void simulatePolyclinic(){

        Patient patient = new Patient();

        patient.takeHealPlan(1);
        patient.takeHealPlan(2);
        patient.takeHealPlan(3);
        patient.takeHealPlan(4);

    }
    private static void simulatePhone() {

        Phone iPhone = new Phone("88005553535", "iPhone 14 Pro Max", 150);
        Phone samsung = new Phone("88005553535", "Samsung Galaxy S 23 Ultra", 180);
        Phone xiaomi = new Phone("880053231335", "Xiaomi Redmi Note 7", 180);

        iPhone.receiveCall("Pasha");
        samsung.receiveCall("Van Darkholme", "88005553535");

        xiaomi.sendMessage("88005553535", "88005553535");

    }
}

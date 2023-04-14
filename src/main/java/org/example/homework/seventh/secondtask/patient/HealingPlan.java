package org.example.homework.seventh.secondtask.patient;


import lombok.AllArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.example.homework.seventh.secondtask.Doctor.Dentist;
import org.example.homework.seventh.secondtask.Doctor.Doctor;
import org.example.homework.seventh.secondtask.Doctor.Surgeon;
import org.example.homework.seventh.secondtask.Doctor.Therapist;

@AllArgsConstructor
@Slf4j
public class HealingPlan {

    private int healCode;


    public void directPatient() {
        switch (healCode) {
            case 1 -> {
                System.out.println("------------------------------------------");
                System.out.println("Visit a surgeon");
                Doctor surgeon = new Surgeon();
                surgeon.heal();
                System.out.println("------------------------------------------");
            }

            case 2 -> {
                System.out.println("------------------------------------------");
                System.out.println("Visit a dentist");
                Doctor dentist = new Dentist();
                dentist.heal();
                System.out.println("------------------------------------------");
            }

            case 3 -> {
                System.out.println("------------------------------------------");
                System.out.println("Visit a therapist");
                Doctor therapist = new Therapist();
                therapist.heal();
                System.out.println("------------------------------------------");
            }

            default -> throw new IllegalStateException("Unexpected heal code: " + healCode);

        }
    }
}

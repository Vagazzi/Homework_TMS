package org.example.homework.seventh.secondtask.patient;

public class Patient {
    private HealingPlan healingPlan;

    public void takeHealPlan(int healCode) {
        healingPlan = new HealingPlan(healCode);
        healingPlan.directPatient();
    }
}

package org.example.homework.seventh.secondTask.Doctor;

import lombok.Getter;
import org.example.homework.seventh.secondTask.Doctor.Doctor;

public class Surgeon extends Doctor {

    @Override
    public void heal(){
        System.out.println("I'll cut some bad things from your body");
    }
}

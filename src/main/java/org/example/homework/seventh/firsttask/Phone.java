package org.example.homework.seventh.firsttask;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Phone {

    private String number;
    private String model;
    private int weight;

    public void receiveCall(String name) {
        System.out.println("Calls " + name);
    }

    public void receiveCall(String name, String callNumber) {
        System.out.println("Calls " + name + " with this number: " + callNumber);
    }

    public void sendMessage(String... recipients) {
        System.out.println("Number phones of recipients: " + Arrays.toString(recipients));
    }

    @Override
    public boolean equals(Object object) {
        Phone phone = (Phone) object;

        return model.equals(phone.model);
    }

}

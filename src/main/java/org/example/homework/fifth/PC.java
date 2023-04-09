package org.example.homework.fifth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class PC {

    private HDD hddStorage;
    private RAM ramStick;

    private String PCModel;
    private double price;

    public PC(String PCModel, double price) {
        this.PCModel = PCModel;
        this.price = price;
        hddStorage = new HDD();
        ramStick = new RAM();
    }

}

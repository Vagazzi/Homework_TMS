package org.example.homework.fifth;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RAM {

    private String nameOfRAM;
    private int volumeOfRAM;

    public RAM(){

    }

    public RAM(String nameOfRAM, int volumeOfRAM) {
        this.nameOfRAM = nameOfRAM;
        this.volumeOfRAM = volumeOfRAM;
    }

    @Override
    public String toString() {
        return "RAM{" +
                "nameOfRAM='" + nameOfRAM + '\'' +
                ", volumeOfRAM=" + volumeOfRAM +
                '}';
    }
}

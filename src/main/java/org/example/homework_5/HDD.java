package org.example.homework_5;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HDD {
    private String nameHDD;
    private int volumeOfHDD;
    private String typeOfHDD;

    public HDD() {

    }

    public HDD(String nameHDD, int volumeOfHDD, String typeOfHDD) {
        this.nameHDD = nameHDD;
        this.volumeOfHDD = volumeOfHDD;
        this.typeOfHDD = typeOfHDD;
    }

    public String getNameHDD() {
        return nameHDD;
    }

    public void setNameHDD(String nameHDD) {
        this.nameHDD = nameHDD;
    }

    public int getVolumeOfHDD() {
        return volumeOfHDD;
    }

    public void setVolumeOfHDD(int volumeOfHDD) {
        this.volumeOfHDD = volumeOfHDD;
    }

    public String getTypeOfHDD() {
        return typeOfHDD;
    }

    public void setTypeOfHDD(String typeOfHDD) {
        this.typeOfHDD = typeOfHDD;
    }

    @Override
    public String toString() {
        return "HDD{" +
                "nameHDD='" + nameHDD + '\'' +
                ", volumeOfHDD=" + volumeOfHDD +
                ", typeOfHDD='" + typeOfHDD + '\'' +
                '}';
    }
}

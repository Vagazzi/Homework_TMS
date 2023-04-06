package org.example.homework_5;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//todo solve this too
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

    @Override
    public String toString() {
        return "HDD{" +
                "nameHDD='" + nameHDD + '\'' +
                ", volumeOfHDD=" + volumeOfHDD +
                ", typeOfHDD='" + typeOfHDD + '\'' +
                '}';
    }
}

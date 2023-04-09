package org.example.homework.fifth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class HDD {

    private String nameHDD;
    private int volumeOfHDD;
    private String typeOfHDD;

    public HDD(String nameHDD, int volumeOfHDD, String typeOfHDD) {
        this.nameHDD = nameHDD;
        this.volumeOfHDD = volumeOfHDD;
        this.typeOfHDD = typeOfHDD;
    }


}

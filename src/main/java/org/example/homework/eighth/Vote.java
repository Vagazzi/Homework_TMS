package org.example.homework.eighth;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;


@Setter
@Getter
public class Vote {

    private final ArrayList<Candidate> candidateList = ElectionComittee.getInstance().getCandidateList();

    private boolean isLukashenko;
    private boolean isTikhanovskaya;
    private boolean isBabariko;
    private boolean againstAll;


}

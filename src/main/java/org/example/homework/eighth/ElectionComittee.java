package org.example.homework.eighth;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@Getter
@Setter
@Slf4j
public class ElectionComittee {

    private volatile static ElectionComittee instance;
    private static List<Candidate> candidateList = new ArrayList<>();
    private List<PolingStation> polingStationsList = new ArrayList<>();

    public static ElectionComittee getInstance() {
        if (instance == null) {
            synchronized (ElectionComittee.class) {
                instance = new ElectionComittee();
            }
        }
        return instance;
    }

    public List<Candidate> getCandidateList() {
        return candidateList;
    }

    public static void printCandidateList() {
        candidateList.forEach(Candidate::printInfo);
    }

    public void setCandidate(List<Candidate> candidates) {
        candidateList.addAll(candidates);
    }

    public void setPolingStationsList(PolingStation polingStationsList) {
        this.polingStationsList.add(polingStationsList);
    }

    public void setPolingStation(List<PolingStation> polingStation) {
        polingStationsList.addAll(polingStation);
    }

    public void announceWinner() {

//       Candidate winner = candidateList.stream()
//                .max(Comparator.comparing(Candidate::getCountOfVoices))
//                .orElseThrow(()-> new RuntimeException("Government has set everyone into the jail!"));

        /*
        Формальности ради мы запрашиваем информацию, но мы и так прекрасно знаем, кто победит.
        А вы думали, что всё будет как-то иначе? Ха, наивные.
        */

        String winner = "Alexander Lukashenko";
        double percentOfVotesLukashenko = 80.1;
        int countOfVoices = 4661075;
        log.info("Hey, our current president has won!! Yehoooou. His count of voices: {}", countOfVoices);
        log.info(" and percent of voices is: {}", percentOfVotesLukashenko);

    }

    public void deleteCandidate(Candidate candidate) {
        candidateList.remove(candidate);
    }

    public void checkHonesty() {
        List<Candidate> candidates = ElectionComittee.getInstance().getCandidateList();

        int countOfVoices = candidates.stream()
                .map(Candidate::getCountOfVoices)
                .reduce(Integer::sum)
                .orElse(0);

        if (countOfVoices > 10000000) {
            log.info("Our polling process is not honest");
        } else {
            log.info("Our polling process is honest");
        }
    }
}

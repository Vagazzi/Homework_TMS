package org.example.homework.eighth;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Slf4j
public class ElectionComittee {

    private static final ElectionComittee instance = new ElectionComittee();
    private static List<Candidate> candidates = new ArrayList<>();
    private List<PolingStation> polingStations = new ArrayList<>();

    public static ElectionComittee getInstance() {
        return instance;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public static void printCandidateList() {
        candidates.forEach(Candidate::printInfo);
    }

    public void addCandidates(List<Candidate> candidates) {
        ElectionComittee.candidates.addAll(candidates);
    }

    public void addPolingStation(PolingStation polingStations) {
        this.polingStations.add(polingStations);
    }

    public void addPolingStation(List<PolingStation> polingStation) {
        polingStations.addAll(polingStation);
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

    public void checkHonesty() {
        List<Candidate> candidates = ElectionComittee.getInstance().getCandidates();

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

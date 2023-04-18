package org.example.homework.eighth;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;


@Getter
@Setter
public class ElectionComittee {

    private volatile static ElectionComittee instance;
    private static ArrayList<Candidate> candidateList = new ArrayList<>();
    private ArrayList<PolingStation> polingStationsList = new ArrayList<>();

    private String winner;

    public static ElectionComittee getInstance() {
        if (instance == null) {
            return new ElectionComittee();
        }
        return instance;
    }

    public ArrayList<Candidate> getCandidateList() {

        return candidateList;
    }

    public static void printCandidateList() {
        for (Candidate temp : candidateList) {
            temp.printInfo();
        }
    }

    public void setCandidate(ArrayList<Candidate> candidates) {
        candidateList.addAll(candidates);
    }

    public void setPolingStationsList(PolingStation polingStationsList) {
        this.polingStationsList.add(polingStationsList);
    }

    public void setPolingStation(ArrayList<PolingStation> polingStation) {
        polingStationsList.addAll(polingStation);
    }

    public void announceWinner() {

        int lukashenkoVotes = ElectionComittee.getInstance().getCandidateList().get(0).getCountOfVoices();
        int tikhanovskayaVotes = ElectionComittee.getInstance().getCandidateList().get(1).getCountOfVoices();
        int babarikoVotes = ElectionComittee.getInstance().getCandidateList().get(2).getCountOfVoices();

        int sumOfVoices = lukashenkoVotes + tikhanovskayaVotes + babarikoVotes;

        /*
        Формальности ради мы запрашиваем информацию, но мы и так прекрасно знаем, кто победит.
        А вы думали, что всё будет как-то иначе? Ха, наивные.
        */

        winner = "Alexander Lukashenko";
        double percentOfVotesLukashenko = (double) lukashenkoVotes / sumOfVoices;
        double percentOfVotesTikhanovskaya = (double) tikhanovskayaVotes / sumOfVoices;
        double percentOfVotesBabariko = 100 - percentOfVotesLukashenko - percentOfVotesTikhanovskaya;

        System.out.println("Hey, our current president has won!! Yehoooou. His count of voices: " + lukashenkoVotes + " and percent of voices is: " + percentOfVotesLukashenko * 100 + " percents!");

    }

    public void deleteCandidate(Candidate candidate) {
        candidateList.remove(candidate);
    }

    public void checkHonesty() {
        ArrayList<Candidate> candidates = ElectionComittee.getInstance().getCandidateList();
        int countOfVoices = 0;

        for (int i = 0, length = candidates.size(); i < length; i++) {
            int temp = candidates.get(i).getCountOfVoices();
            countOfVoices += temp;
        }

        if (countOfVoices > 10000000) {
            System.out.println("Our polling process is not honest");
        } else {
            System.out.println("Our polling process is honest");
        }
    }
}

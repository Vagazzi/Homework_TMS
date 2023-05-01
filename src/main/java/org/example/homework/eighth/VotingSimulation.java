package org.example.homework.eighth;

import java.util.ArrayList;
import java.util.List;

public class VotingSimulation {
    public static void main(String[] args) {

        ElectionComittee electionComittee = ElectionComittee.getInstance();

        List<Candidate> candidates = initializeCandidates();
        List<PolingStation> polingStationsList = initializePolingStations();
        List<Person> people = initializePeople();

        electionComittee.addCandidates(candidates);
        electionComittee.addPolingStation(polingStationsList);

        ElectionComittee.printCandidateList();

        vote(people);

        electionComittee.checkHonesty();

        candidates.forEach(Candidate::printInfo);

        polingStationsList.forEach(PolingStation::printInfo);

        electionComittee.announceWinner();

        candidates.forEach(Candidate::printInfo);

    }

    private static List<Candidate> initializeCandidates() {

        Candidate currentPresident = new Candidate("Alexander Lukashenko", 68, 1000);
        Candidate newPresident = new Candidate("Svetlana Tikhanovskaya", 40, 1);
        Candidate formerCandidate = new Candidate("Victor Babariko", 59, 1);
        Candidate againstAllCandidate = new Candidate("Against all", 0, 1);

        return List.of(currentPresident, newPresident, formerCandidate, againstAllCandidate);

    }

    private static List<PolingStation> initializePolingStations() {

        PolingStation parliament = new PolingStation("st. Pushkina, d. Kolotushkina", 1111111, 1000);
        PolingStation school = new PolingStation("st. Pushkina, d. Kolotushkina 37", 1111111, 455);

        return List.of(parliament, school);

    }

    private static List<Person> initializePeople() {

        List<Person> personList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            personList.add(new Person("Alex", i));
        }

        return personList;
    }

    private static void vote(List<Person> people) {

        for (int i = 0, size = people.size(); i < size; i += 4) {
            people.get(i).vote("Alexander Lukashenko");
        }

        for (int i = 1, size = people.size(); i < size; i += 4) {
            people.get(i).vote("Svetlana Tikhanovskaya");
        }

        for (int i = 2, size = people.size(); i < size; i += 4) {
            people.get(i).vote("Victor Babariko");
        }

        for (int i = 3, size = people.size(); i < size; i += 4) {
            people.get(i).vote("Against all");
        }

    }
}

package org.example.homework.eighth;

import java.util.List;

public class VotingSimulation {
    public static void main(String[] args) {

        ElectionComittee electionComittee = ElectionComittee.getInstance();

        List<Candidate> candidates = initializeCandidates();
        List<PolingStation> polingStationsList = initializePolingStations();
        List<Person> people = initializePeople();

        electionComittee.setCandidate(candidates);
        electionComittee.setPolingStation(polingStationsList);

        ElectionComittee.printCandidateList();

        vote(people);

        electionComittee.checkHonesty();

        candidates.forEach(Candidate::printInfo);

        polingStationsList.forEach(PolingStation::printInfo);

        electionComittee.announceWinner();

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

        Person alex = new Person("Alex", 54);
        Person pasha = new Person("Pasha", 30);
        Person natasha = new Person("Natasha", 21);

        return List.of(alex, pasha, natasha);
    }

    private static void vote(List<Person> people) {

        people.get(0).vote("Alexander Lukashenko");
        people.get(1).vote("Svetlana Tikhanovskaya");
        people.get(2).vote("Against all");
    }
}

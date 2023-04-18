package org.example.homework.eighth;

import java.util.ArrayList;

public class VotingSimulation {
    public static void main(String[] args) {

        ElectionComittee electionComittee = ElectionComittee.getInstance();
        ArrayList<Candidate> candidates = initializeCandidates();
        ArrayList<PolingStation> polingStationsList = initializePolingStations();
        ArrayList<Person> people = initializePeople();

        electionComittee.setCandidate(candidates);
        electionComittee.setPolingStation(polingStationsList);

        ElectionComittee.printCandidateList();

        vote(polingStationsList, people);

        electionComittee.checkHonesty();

        candidates.get(0).printInfo();
        candidates.get(1).printInfo();
        candidates.get(2).printInfo();

        for (PolingStation i: polingStationsList){
            i.printInfo();
        }

        electionComittee.announceWinner();

    }

    private static ArrayList<Candidate> initializeCandidates() {

        ArrayList<Candidate> temp = new ArrayList<>();

        Candidate currentPresident = new Candidate("Alexander Lukashenko", 68);
        Candidate newPresident = new Candidate("Svetlana Tikhanovskaya", 40);
        Candidate formerCandidate = new Candidate("Victor Babariko", 59);

        temp.add(currentPresident);
        temp.add(newPresident);
        temp.add(formerCandidate);

        return temp;

    }

    private static ArrayList<PolingStation> initializePolingStations() {

        ArrayList<PolingStation> tempList = new ArrayList<>();

        PolingStation parliament = new PolingStation("st. Pushkina, d. Kolotushkina", 1111111, 1000);
        PolingStation school = new PolingStation("st. Pushkina, d. Kolotushkina 37", 1111111, 455);

        tempList.add(parliament);
        tempList.add(school);

        return tempList;

    }

    private static ArrayList<Person> initializePeople() {
        ArrayList<Person> tempList = new ArrayList<>();

        Person alex = new Person("Alex", 54);
        Person pasha = new Person("Pasha", 30);
        Person natasha = new Person("Natasha", 21);

        tempList.add(alex);
        tempList.add(pasha);
        tempList.add(natasha);

        return tempList;
    }

    private static void vote(ArrayList<PolingStation> polingStations, ArrayList<Person> people) {

        people.get(0).vote(polingStations.get(0), "Alexander Lukashenko");
        people.get(1).vote(polingStations.get(1), "Svetlana Tikhanovskaya");
        people.get(2).vote(polingStations.get(0), "Against all");

    }
}

package org.example.homework.eighth;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
public class Person {

    private Vote vote;

    private int age;
    private String name;

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public void printInfo() {
        System.out.println();
        System.out.println("We have a information about this person: ");
        System.out.println("His credentials: " + this.name);
        System.out.println("His age: " + this.age);
    }

    public void vote(PolingStation polingStation,String candidate) {

        vote = new Vote();

        ArrayList<Candidate> candidates = ElectionComittee.getInstance().getCandidateList();

        switch (candidate) {
            case "Alexander Lukashenko" -> {
                vote.setLukashenko(true);
                candidates.get(0).incrementVotes(1000);
            }
            case "Svetlana Tikhanovskaya" -> {
                vote.setTikhanovskaya(true);
                candidates.get(1).incrementVotes(1);
            }
            case "Victor Babariko" -> {
                vote.setBabariko(true);
                candidates.get(2).incrementVotes(1);
            }
            case "Against all" -> {
                vote.setAgainstAll(true);
                polingStation.incrementVotes();
            }
            default -> {
                System.out.println("This candidate is not exists!");
            }
        }

    }
}

package org.example.homework.eighth;

public class Candidate extends Person {

    private int countOfVoices;

    public Candidate(String name, int age) {
        super(name, age);
    }

    public int getCountOfVoices() {
        return countOfVoices;
    }

    public void incrementVotes(int increment) {
        countOfVoices += increment;
    }

    @Override
    public void printInfo() {
        System.out.println();
        System.out.println("We have a information about this candidate: ");
        System.out.println("His credentials: " + super.getName());
        System.out.println("His age: " + super.getAge());
        System.out.println("Count of voices: " + countOfVoices);
    }
}

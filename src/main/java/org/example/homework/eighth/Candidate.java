package org.example.homework.eighth;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Candidate extends Person {

    private int countOfVoices;
    private final double voteMultiplier;

    public Candidate(String name, int age, double voteMultiplier) {
        super(name, age);
        this.voteMultiplier = voteMultiplier;
    }

    public int getCountOfVoices() {
        return countOfVoices;
    }

    public void incrementVotes() {
        countOfVoices += 1 * voteMultiplier;
    }

    @Override
    public void printInfo() {
        log.info("\n We have a information about this candidate: ");
        log.info("His credentials: {}", super.getName());
        log.info("His age: {}", super.getAge());
        log.info("Count of voices: {}", countOfVoices);
    }
}

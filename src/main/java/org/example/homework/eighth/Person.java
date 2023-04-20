package org.example.homework.eighth;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Setter
@Getter
@Slf4j
public class Person {

    private String selectedCandidate;
    private boolean isVoted = false;
    private int age;
    private String name;

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public void printInfo() {

        log.info("\n We have a information about this person: ");
        log.info("His credentials: {} ", this.name);
        log.info("His age: {}", this.age);

    }

    public void vote(String candidateName) {

        if (isVoted) {
            System.out.println("You have been voted, go away");
            return;
        }

        List<Candidate> candidates = ElectionComittee.getInstance().getCandidates();

        Candidate candidate = candidates.stream()
                .filter(candidate1 -> candidate1.getName().equals(candidateName))
                .findFirst()
                .orElse(null);

        if (candidate == null) {
            log.info("Candidate not found");
            return;
        }

        isVoted = true;

        candidate.incrementVotes();


        selectedCandidate = candidate.getName();
    }
}

package org.example.homework.eighth;

import java.util.ArrayList;
import java.util.List;


public class PolingStation {

    private List<Person> people = new ArrayList<>();
    private String address;
    private int postCode;
    private int countOfPeople;

    private int countOfAgainstAllVotes = 0;

    public PolingStation(String address, int postCode, int countOfPeople) {

        this.address = address;
        this.postCode = postCode;
        this.countOfPeople = countOfPeople;

    }

    public void addPeopleToPolingStation(Person person) {

        if (people.size() > countOfPeople) {
            System.out.println("Something goes wrong, try again");
            return;
        } else {
            people.add(person);
        }
    }

    public void incrementVotes() {
        this.countOfAgainstAllVotes++;
    }

    public void printInfo() {
        System.out.println();
        System.out.println("We have a information about this poling station: ");
        System.out.println("His address: " + this.address);
        System.out.println("His post code: " + this.postCode);
        System.out.println("Count of people: " + this.countOfPeople);
        System.out.println("Count of votes against all candidates: " + this.countOfAgainstAllVotes);
    }
}

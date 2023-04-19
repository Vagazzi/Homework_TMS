package org.example.homework.eighth;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;


@Slf4j
public class PolingStation {

    private final List<Person> people = new ArrayList<>();
    private final String address;
    private final int postCode;
    private final int countOfPeople;


    public PolingStation(String address, int postCode, int countOfPeople) {

        this.address = address;
        this.postCode = postCode;
        this.countOfPeople = countOfPeople;

    }

    public void addPeopleToPolingStation(Person person) {
        if (people.size() > countOfPeople) {
            System.out.println("Something goes wrong, try again");
        } else {
            people.add(person);
        }
    }

    public void printInfo() {
        log.info("\n We have a information about this poling station: ");
        log.info("His address: {}", this.address);
        log.info("His post code: {}", this.postCode);
        log.info("Count of people: {}", this.countOfPeople);
    }
}

package org.example.homework.fourteenth;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.stream.Collectors;


@Slf4j
public class FourteenthHometask {
    public static void main(String[] args) {
        //firstTask();
        secondTask();


    }

    private static void firstTask() {
        List<Integer> list = new ArrayList<>();
        fillList(list);

        System.out.println("Initial stream");
        list.forEach(System.out::println);

        System.out.println("Stream with unique elements");
        list.stream().distinct().toList().forEach(System.out::println);

        System.out.println("Stream with elements in range [7..17]");
        list.stream().filter(x -> x > 7 && x < 17).forEach(System.out::println);

        System.out.println("Stream with multiplied elements by 2");
        list.stream().map(x -> x * 2).forEach(System.out::println);

        System.out.println("Sorted stream with first four elements in them");
        list.stream().sorted().limit(4).forEach(System.out::println);

        int count = (int) list.stream().count();
        System.out.println("Count of elements in collection is: " + count);

        OptionalDouble average = list.stream().mapToInt(a -> a).average();
        System.out.println("Average sum of elements is: " + average.getAsDouble());
    }

    private static void secondTask() {
        List<String> students = new ArrayList<>();

        students.add("Vadim");
        students.add("Pasha");
        students.add("Alex");
        students.add("Valentin");
        students.add("Vadim");
        students.add("Anastasiya");
        students.add("Alex");
        students.add("asbek");

        students.stream().filter(x -> x.contains("Vadim")).forEach(System.out::println);
        students.stream().filter(x -> x.startsWith("A") || x.startsWith("a")).forEach(System.out::println);
        String element = students.stream().sorted().limit(1).findFirst().orElse("Empty");
        log.info("{}", element);

    }


    private static List<Integer> fillList(List<Integer> list) {
        for (int i = 0; i < 20; i++) {
            Random random = new Random();
            list.add(i, random.nextInt(20));
        }
        return list;
    }
}

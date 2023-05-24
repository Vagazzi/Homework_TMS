package org.example.homework.fourteenth;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.function.Predicate;


@Slf4j
public class FourteenthHometask {
    public static void main(String[] args) {
        //firstTask();
        secondTask();


    }

    private static void firstTask() {
        List<Integer> elements = new ArrayList<>();
        fillList(elements);

        System.out.println("Initial stream");
        elements.forEach(System.out::println);

        System.out.println("Stream with unique elements");
        elements.stream().distinct().toList().forEach(System.out::println);

        System.out.println("Stream with elements in range [7..17]");
        elements.stream().filter(getIntegerFromRange()).forEach(System.out::println);

        System.out.println("Stream with multiplied elements by 2");
        elements.stream().map(x -> x * 2).forEach(System.out::println);

        System.out.println("Sorted stream with first four elements in them");
        elements.stream().sorted().limit(4).forEach(System.out::println);

        int count = (int) elements.stream().count();
        System.out.println("Count of elements in collection is: " + count);

        OptionalDouble average = elements.stream().mapToInt(a -> a).average();
        System.out.println("Average sum of elements is: " + average.getAsDouble());
    }

    @NotNull
    private static Predicate<Integer> getIntegerFromRange() {
        return x -> (x > 7 && x < 17) && x % 2 == 0;
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
        String element = students.stream().sorted().findFirst().orElse("Empty");
        log.info("{}", element);

    }


    private static List<Integer> fillList(List<Integer> list) {
        for (int i = 0; i < 20; i++) {
            Random random = new Random();
            list.add(random.nextInt(20));
        }
        return list;
    }
}

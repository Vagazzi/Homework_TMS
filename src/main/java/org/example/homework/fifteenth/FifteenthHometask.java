package org.example.homework.fifteenth;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FifteenthHometask {
    public static void main(String[] args) {
        List<Book> library = initializeLibrary();
        sortByYear(library);
        groupByAuthor(library);
        countBookByYear(library);
        countBookByAuthor(library);
        groupByFirstLetter(library);
    }

    private static List<Book> initializeLibrary() {
        return List.of(new Book(1990, "Pushkin", "Neonuar"),
                new Book(1920, "Dostoevsky", "War and peace"),
                new Book(1812, "Pushkin", "The Godfather"),
                new Book(2014, "Dostoevsky", "Effective programming"),
                new Book(1977, "Pushkin", "C++"),
                new Book(1920, "Dostoevsky", "Concurrency"),
                new Book(1974, "Pushkin", "Ambient"),
                new Book(1929, "Dostoevsky", "A Mein Kampf"));
    }

    private static List<Book> sortByYear(List<Book> library) {

        return library.stream()
                .sorted(Book::compareToYear)
                .toList();

    }

    private static Map<String, List<Book>> groupByAuthor(List<Book> library) {

        return library.stream()
                .collect(Collectors.groupingBy(
                        Book::getAuthor));

    }

    private static Map<Integer, Long> countBookByYear(List<Book> library) {

        return library.stream()
                .collect(Collectors.groupingBy(
                        Book::getYear, Collectors.counting()));

    }

    private static Map<String, Long> countBookByAuthor(List<Book> library) {

        return library.stream()
                .collect(Collectors.groupingBy(
                        Book::getAuthor, Collectors.counting()));

    }

    private static Map<Character, List<Book>> groupByFirstLetter(List<Book> library) {

        return library.stream()
                .collect(Collectors.groupingBy(Book::getFirstLetter));

    }
}

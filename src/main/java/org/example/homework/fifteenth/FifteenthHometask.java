package org.example.homework.fifteenth;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FifteenthHometask {
    public static void main(String[] args) {
        List<Book> library = addBooks();
        sortByYear(library);
        groupByAuthor(library);
        countBookByYear(library);
        countBookByAuthor(library);
        groupByFirstLetter(library);
    }

    private static List<Book> addBooks() {
        return List.of(new Book(1990, "Pushkin", "Neonuar"),
                new Book(1920, "Dostoevsky", "War and peace"),
                new Book(1812, "Pushkin", "The Godfather"),
                new Book(2014, "Dostoevsky", "Effective programming"),
                new Book(1977, "Pushkin", "C++"),
                new Book(1920, "Dostoevsky", "Concurrency"),
                new Book(1974, "Pushkin", "Ambient"),
                new Book(1929, "Dostoevsky", "A Mein Kampf"));
    }

    private static void sortByYear(List<Book> library) {

        library.stream()
                .sorted(Book::compareToYear)
                .toList()
                .forEach(System.out::println);

    }

    private static void groupByAuthor(List<Book> library) {

        library.stream()
                .collect(Collectors.groupingBy(
                        Book::getAuthor));

    }

    private static void countBookByYear(List<Book> library) {

        library.stream()
                .collect(Collectors.groupingBy(
                        Book::getYear, Collectors.counting()));

    }

    private static void countBookByAuthor(List<Book> library) {

        library.stream()
                .collect(Collectors.groupingBy(
                        Book::getAuthor, Collectors.counting()));

    }

    private static void groupByFirstLetter(List<Book> library){

         library.stream()
                .collect(Collectors.groupingBy(Book::getFirstLetter));

    }
}

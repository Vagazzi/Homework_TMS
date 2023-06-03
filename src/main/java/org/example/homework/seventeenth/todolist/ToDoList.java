package org.example.homework.seventeenth.todolist;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.homework.seventeenth.todolist.Messages.*;
import static org.example.homework.seventeenth.todolist.ToDoCrud.printTaskList;


@Getter
@ToString
public class ToDoList {

    private static final List<ToDoTask> tasks = new ArrayList<>();

    public static List<ToDoTask> getTasks() {
        return tasks;
    }

    public static boolean isEmptyTaskList() {
        if (ToDoList.getTasks().isEmpty()) {
            System.out.println("Your to-do list is empty already");
            return true;
        }
        return false;
    }

    public static void removeAllElements() {

        printTaskList(DEFAULT_MESSAGE);

        System.out.println("""
                    Are you sure to delete everything from to-do list?
                    Type "Yes" or "No".
                """);

        Scanner newScanner = new Scanner(System.in);
        String input = newScanner.nextLine();
        switch (input) {

            case "yes", "YES", "Yes" -> {
                tasks.removeAll(tasks);
                printTaskList(DEFAULT_MESSAGE);
            }
            case "No", "NO", "no" -> {
                return;
            }
            default -> System.out.println("Invalid input was detected, try again");
        }
    }

    public static void removeElementByPosition() {

        printTaskList(DEFAULT_MESSAGE);

        System.out.println("Select the position of task");
        Scanner intScanner = new Scanner(System.in);
        int position = intScanner.nextInt();
        tasks.remove(position);

        System.out.println("New to-do list:");
        printTaskList(NEW_MESSAGE);

    }

}

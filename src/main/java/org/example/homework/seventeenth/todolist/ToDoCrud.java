package org.example.homework.seventeenth.todolist;

import org.example.homework.fourth.InvalidNumberException;
import org.example.homework.seventeenth.todolist.enums.CompletionStatus;
import org.example.homework.seventeenth.todolist.enums.Priority;

import java.io.*;
import java.util.Scanner;

import static org.example.homework.seventeenth.todolist.JsonFileHandler.readFromFile;
import static org.example.homework.seventeenth.todolist.JsonFileHandler.writeJsonInFile;
import static org.example.homework.seventeenth.todolist.Messages.*;
import static org.example.homework.seventeenth.todolist.ToDoList.*;
import static org.example.homework.seventeenth.todolist.ToDoTask.*;


public class ToDoCrud {

    public static void main(String[] args) throws InvalidNumberException, IOException {

        printMenu();

    }

    private static void printMenu() throws InvalidNumberException, IOException {

        System.out.println("Your to-do list application");

        while (true) {

            System.out.println(MENU_MESSAGE);

            Scanner scanner = new Scanner(System.in);
            int optionNumber = scanner.nextInt();

            switch (optionNumber) {
                case 1 -> addTask();
                case 2 -> printTaskList(DEFAULT_MESSAGE);
                case 3 -> deleteTasks();
                case 4 -> editInfo();
                case 5 -> writeJsonInFile();
                case 6 -> readFromFile();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid input was detected, try again");
            }
        }
    }

    private static void addTask() {

        System.out.println("-------------------------");

        System.out.println("Enter the task text");
        Scanner scanner = new Scanner(System.in);

        String taskText = scanner.nextLine();

        try {

            int priority = getInput(scanner, TASK_PRIORITY_MESSAGE);
            Priority taskPriority = convertPriorityInput(priority);
            ToDoList.getTasks().add(new ToDoTask(taskText, taskPriority, CompletionStatus.NOT_COMPLETED));

        } catch (InvalidNumberException e) {
            e.printStackTrace();
        }

        System.out.println("-------------------------");
    }
    private static void deleteTasks() {

        if (isEmptyTaskList()) return;

        System.out.println(REMOVING_MESSAGE);

        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {

            case 1 -> removeElementByPosition();
            case 2 -> removeAllElements();
            default -> System.out.println("Invalid input was detected, try again");

        }
    }
    public static int getInput(Scanner scanner, String message) {

        System.out.println(message);

        return scanner.nextInt();
    }
    public static void printTaskList(String message) {

        System.out.println("--------------------------------------------------");
        if (ToDoList.getTasks().isEmpty()) {
            System.out.println("Your to-do list is empty!");
        } else {
            System.out.println(message);
            System.out.println(ToDoList.getTasks());
        }
        System.out.println("--------------------------------------------------");
    }
    private static void editInfo() throws InvalidNumberException {

        if (isEmptyTaskList()) return;

        printTaskList(DEFAULT_MESSAGE);

        System.out.println("Select the task: ");
        Scanner taskScanner = new Scanner(System.in);
        int position = taskScanner.nextInt();
        ToDoTask editingTask = ToDoList.getTasks().get(position);

        System.out.println("""
                Select the kind of editing info:
                1) Edit the priority of task;
                2) Edit the text of task;
                3) Edit the status of completion task;
                """);
        Scanner editScanner = new Scanner(System.in);
        switch (editScanner.nextInt()) {
            case 1 -> editPriority(editingTask);
            case 2 -> editText(editingTask);
            case 3 -> editCompletionStatus(editingTask);
            default -> System.out.println("Invalid input was detected, try again");
        }
    }

}

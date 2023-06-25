package org.example.homework.seventeenth.todolist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.homework.fourth.InvalidNumberException;
import org.example.homework.seventeenth.todolist.enums.CompletionStatus;
import org.example.homework.seventeenth.todolist.enums.Priority;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.example.homework.seventeenth.todolist.Messages.*;

@AllArgsConstructor
public class ToDoCrud {

    private long initialCounter = 1;
    private static long currentCounter;
    private final ToDoTaskService taskService;
    private final ToDoList toDoList;
    private final JsonFileHandler jsonFileHandler;

    public void printMenu() throws InvalidNumberException, IOException {

        System.out.println("Your to-do list application");

        while (true) {

            System.out.println(MENU_MESSAGE);

            Scanner scanner = new Scanner(System.in);
            int optionNumber = scanner.nextInt();

            switch (optionNumber) {
                case 1 -> addTask();
                case 2 -> toDoList.printTaskList(DEFAULT_MESSAGE);
                case 3 -> deleteTask();
                case 4 -> editInfo();
                case 5 -> jsonFileHandler.writeJsonInFile(toDoList);
                case 6 -> jsonFileHandler.readFromFile(toDoList);
                case 0 -> {
                    return;
                }
                default -> System.out.println("Invalid input was detected, try again");
            }
        }
    }

    private void addTask() {

        System.out.println("-------------------------");

        System.out.println("Enter the task text");
        Scanner scanner = new Scanner(System.in);

        String taskText = scanner.nextLine();

        try {

            int priority = getIntegerValueFromClient(scanner, TASK_PRIORITY_MESSAGE);
            Priority taskPriority = taskService.convertPriorityInput(priority);

            if(toDoList.getTasks().get(toDoList.getTasks().size() - 1).getId() == 0)
                currentCounter++;

            currentCounter = toDoList.getTasks().get(toDoList.getTasks().size() - 1).getId();
            toDoList.getTasks().add(new ToDoTask(currentCounter, taskText, taskPriority, CompletionStatus.NOT_COMPLETED));

        } catch (InvalidNumberException | NoSuchElementException e) {
            e.printStackTrace();
        }

        System.out.println("-------------------------");
    }

    private void deleteTask() {

        if (toDoList.isEmptyTaskList()) return;

        toDoList.printTaskList(DEFAULT_MESSAGE);
        System.out.println(REMOVING_MESSAGE);

        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()) {

            case 1 -> {

                System.out.println("Select the id of task");
                int id = scanner.nextInt();
                toDoList.removeElementById(id);
                System.out.println("New to-do list:");

            }
            case 2 -> {
                System.out.println(REMOVING_EVERYTHING_MESSAGE);
                String decision = scanner.nextLine();
                while (!(decision = scanner.nextLine()).isEmpty()) {
                    toDoList.removeAllElements(decision);
                }
            }
            default -> System.out.println("Invalid input was detected, try again");

        }

        toDoList.printTaskList(NEW_MESSAGE);
    }

    private int getIntegerValueFromClient(Scanner scanner, String message) {

        System.out.println(message);

        return scanner.nextInt();
    }


    private void editInfo() throws InvalidNumberException {

        if (toDoList.isEmptyTaskList()) return;

        toDoList.printTaskList(DEFAULT_MESSAGE);

        System.out.println("Select the task: ");
        Scanner taskScanner = new Scanner(System.in);
        int position = taskScanner.nextInt();
        ToDoTask editingTask = toDoList.getTasks().get(position);

        System.out.println("""
                Select the kind of editing info:
                1) Edit the priority of task;
                2) Edit the text of task;
                3) Edit the status of completion task;
                """);

        switch (taskScanner.nextInt()) {

            case 1 -> {
                int priority = getIntegerValueFromClient(taskScanner, COMPLETION_STATUS_MESSAGE);
                taskService.editPriority(editingTask, priority);
            }
            case 2 -> {
                System.out.println("Enter the new task text");
                taskService.editText(editingTask, taskScanner.next());
            }
            case 3 -> {
                int competitionStatus = getIntegerValueFromClient(taskScanner, COMPLETION_STATUS_MESSAGE);
                taskService.editCompletionStatus(editingTask, competitionStatus);
            }
            default -> System.out.println("Invalid input was detected, try again");

        }

        toDoList.printTaskList(NEW_MESSAGE);
    }

}

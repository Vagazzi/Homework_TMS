package org.example.homework.seventeenth.todolist;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.example.homework.fourth.InvalidNumberException;
import org.example.homework.seventeenth.todolist.enums.CompletionStatus;
import org.example.homework.seventeenth.todolist.enums.Priority;

import java.util.Scanner;

import static org.example.homework.seventeenth.todolist.Messages.*;
import static org.example.homework.seventeenth.todolist.Messages.NEW_MESSAGE;
import static org.example.homework.seventeenth.todolist.ToDoCrud.getInput;
import static org.example.homework.seventeenth.todolist.ToDoCrud.printTaskList;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class ToDoTask {

    @JsonProperty("id")
    private long id;

    public ToDoTask(String task, Priority priority, CompletionStatus status) {
        id++;
        this.task = task;
        this.priority = priority;
        this.status = status;
    }

    @JsonProperty("task")
    private String task;

    @JsonProperty("priority")
    private Priority priority;

    @JsonProperty("status")
    private CompletionStatus status;

    public static void editCompletionStatus(ToDoTask editingTask) throws InvalidNumberException {
        Scanner statusScanner = new Scanner(System.in);
        int completionStatus = getInput(statusScanner, COMPLETION_STATUS_MESSAGE);
        editingTask.setStatus(convertCompletionStatus(completionStatus));
        printTaskList(NEW_MESSAGE);
    }

    public static void editPriority(ToDoTask editingTask) throws InvalidNumberException {

        Scanner priorityScanner = new Scanner(System.in);
        int priority = getInput(priorityScanner, TASK_PRIORITY_MESSAGE);
        editingTask.setPriority(convertPriorityInput(priority));
        printTaskList(NEW_MESSAGE);
    }

    public static void editText(ToDoTask editingTask) {

        System.out.println("Enter the new task text");
        Scanner textScanner = new Scanner(System.in);
        editingTask.setTask(textScanner.nextLine());
        printTaskList(NEW_MESSAGE);

    }

    public static Priority convertPriorityInput(int priority) throws InvalidNumberException {
        if (priority < 1 || priority > 3) {
            throw new InvalidNumberException("This number is not in range [1..3]");
        }

        if (priority == 1) {
            return Priority.LOW;
        }

        if (priority == 2) {
            return Priority.MEDIUM;
        }

        return Priority.HIGH;
    }

    public static CompletionStatus convertCompletionStatus(int status) throws InvalidNumberException {

        if (status < 1 || status > 3) {
            throw new InvalidNumberException("This number is not in range [1..3]");
        }

        if (status == 1) {
            return CompletionStatus.NOT_COMPLETED;
        }

        if (status == 2) {
            return CompletionStatus.IN_PROCESS;
        }

        return CompletionStatus.COMPLETED;
    }

}

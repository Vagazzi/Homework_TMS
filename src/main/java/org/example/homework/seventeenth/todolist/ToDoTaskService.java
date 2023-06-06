package org.example.homework.seventeenth.todolist;

import org.example.homework.fourth.InvalidNumberException;
import org.example.homework.seventeenth.todolist.enums.CompletionStatus;
import org.example.homework.seventeenth.todolist.enums.Priority;

public class ToDoTaskService {
    public void editCompletionStatus(ToDoTask editingTask, int completionStatus) throws InvalidNumberException {
        editingTask.setStatus(convertCompletionStatus(completionStatus));
    }

    public void editPriority(ToDoTask editingTask, int priority) throws InvalidNumberException {
        editingTask.setPriority(convertPriorityInput(priority));
    }

    public void editText(ToDoTask editingTask, String taskText) {
        editingTask.setTask(taskText);
    }

    public Priority convertPriorityInput(int priority) throws InvalidNumberException {

        switch (priority) {
            case 1 -> {
                return Priority.LOW;
            }
            case 2 -> {
                return Priority.MEDIUM;
            }
            case 3 -> {
                return Priority.HIGH;
            }
            default -> throw new InvalidNumberException("This number is not in range [1..3]");
        }
    }

    public CompletionStatus convertCompletionStatus(int status) throws InvalidNumberException {

        switch (status) {
            case 1 -> {
                return CompletionStatus.NOT_COMPLETED;
            }
            case 2 -> {
                return CompletionStatus.IN_PROCESS;
            }
            case 3 -> {
                return CompletionStatus.COMPLETED;
            }
            default -> throw new InvalidNumberException("This number is not in range [1..3]");
        }
    }
}

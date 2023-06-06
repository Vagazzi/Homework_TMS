package org.example.homework.seventeenth.todolist;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Getter
@ToString
public class ToDoList {

    private final List<ToDoTask> tasks = new ArrayList<>();

    public List<ToDoTask> getTasks() {
        return tasks;
    }

    public boolean isEmptyTaskList() {
        if (tasks.isEmpty()) {
            System.out.println("Your to-do list is empty already");
            return true;
        }
        return false;
    }

    public void removeAllElements(String decision) {

        if(decision.equalsIgnoreCase("Yes")){
            tasks.clear();
        } else if(decision.equalsIgnoreCase("No")){
            return;
        } else {
            System.out.println("Invalid input was detected, try again");
        }
    }

    public void printTaskList(String message) {

        System.out.println("--------------------------------------------------");
        if (tasks.isEmpty()) {
            System.out.println("Your to-do list is empty!");
        } else {
            System.out.println(message);
            System.out.println(tasks);
        }
        System.out.println("--------------------------------------------------");
    }

    public void removeElementById(int id) {
        tasks.removeIf(task -> task.getId() == id);
    }

}

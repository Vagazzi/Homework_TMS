package org.example.homework.seventeenth.todolist;

import org.example.homework.fourth.InvalidNumberException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InvalidNumberException, IOException {

        final ToDoTaskService taskService = new ToDoTaskService();
        final ToDoList toDoList = new ToDoList();
        final JsonFileHandler jsonFileHandler = new JsonFileHandler();

        ToDoCrud crud = new ToDoCrud(taskService, toDoList, jsonFileHandler);
        crud.printMenu();
    }
}

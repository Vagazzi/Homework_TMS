package org.example.homework.seventeenth.todolist;

import org.example.homework.fourth.InvalidNumberException;
import org.example.homework.seventeenth.todolist.ToDoCrud;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InvalidNumberException, IOException {
        ToDoCrud crud = new ToDoCrud(new ToDoTaskService(), new ToDoList(), new JsonFileHandler());
        crud.printMenu();
    }
}

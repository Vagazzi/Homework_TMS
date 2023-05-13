package org.example.homework.eleventh;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// filepath - C:\\Users\\Vagazzi\\IdeaProjects\\Homework_TMS\\src\\main\\java\\org\\example\\homework\\eleventh\\files\\templates.txt"

@Slf4j
@Getter
public class FileReader {

    public String requestFilePath() {

        log.info("Enter the absolute path to the file"); // чтение из файла templates.txt
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }

    protected List<String> readFromFile(String filePath) {

        List<String> numbers = new ArrayList<>();

        try {
            numbers = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            log.error(e.toString());
        }

        return numbers;
    }

}

package org.example.homework.seventeenth.todolist;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Slf4j
@Getter
public class JsonFileHandler {

    private static final String FILE_PATH = "C:\\Users\\Vagazzi\\IdeaProjects\\Homework_TMS\\src\\main\\java\\org\\example\\homework\\seventeenth\\files\\todolist.json";

    public static String getFilePath() {
        return FILE_PATH;
    }

    public  void writeJsonInFile(ToDoList list) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(list.getTasks());

        System.out.println("Summary JSON");
        System.out.println(jsonString);

        try (PrintWriter pw = new PrintWriter(new FileOutputStream(FILE_PATH), false)) {
            pw.println(jsonString);
        } catch (IOException e) {
            log.error("{}", e.getMessage());
        }
    }

    public  void readFromFile(ToDoList list) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        File file = new File(JsonFileHandler.getFilePath());

        List<ToDoTask> tasks = mapper.readValue(file, new TypeReference<>() {
        });

        System.out.println(tasks);

        for (ToDoTask task : tasks) {
            list.getTasks().add(task);
        }

    }
}

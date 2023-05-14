package org.example.homework.twelveth;

import lombok.extern.slf4j.Slf4j;
import org.example.homework.eleventh.FileReader;
import org.example.homework.eleventh.FileWriter;

import java.security.InvalidKeyException;
import java.util.*;

@Slf4j
public class TwelvethHometask {

    private static final String filepath = "C:\\Users\\Vagazzi\\IdeaProjects\\Homework_TMS\\src\\main\\java\\org\\example\\homework\\twelveth\\numbers.txt";
    private static final String initialStringPoolFilePath = "C:\\Users\\Vagazzi\\IdeaProjects\\Homework_TMS\\src\\main\\java\\org\\example\\homework\\twelveth\\stringlist.txt";
    private static final String revertedStringPoolFilePath = "C:\\Users\\Vagazzi\\IdeaProjects\\Homework_TMS\\src\\main\\java\\org\\example\\homework\\twelveth\\revertedlist.txt";
    List<String> berriesList = new ArrayList<>();
    List<String> vegetablesList = new ArrayList<>();
    List<String> fruitList = new ArrayList<>();

    public void firstTask() {
        String initialString = "apple pen abbey duck cock bird bitard Animal";

        List<String> wordList = new ArrayList<>(Arrays.stream(initialString.split(" ")).toList());

        Collections.sort(wordList);

        wordList.forEach(log::info);
    }

    public void secondTask() {

        FileReader fileReader = new FileReader();
        List<String> result = fileReader.readFromFile(filepath);  // ни бейте насяника, уже была реализация ранее, а новую писать немного лень

        new LinkedHashSet<>(result).forEach(log::info);

    }

    public void thirdTask() {
        Map<String, List<String>> edibleItems = new HashMap<>();

        int counter = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            while (counter <= 10) {

                log.info("Enter the valid category");
                String inputCategory = scanner.nextLine();
                inputCategoryCheck(inputCategory);

                log.info("Enter the item");
                String item = scanner.nextLine();
                putDataIntoList(item);

                counter++;
            }
        } catch (InvalidKeyException e) {
            log.info("{}", e.getMessage());
        }

        edibleItems.put("fruits", fruitList);
        edibleItems.put("vegetables", vegetablesList);
        edibleItems.put("berries", berriesList);

        log.info("fruits = {}", edibleItems.get("fruits"));
        log.info("fruits = {}", edibleItems.get("vegetables"));
        log.info("fruits = {}", edibleItems.get("berries"));

    }

    private static void inputCategoryCheck(String categoryInput) throws InvalidKeyException {
        if (!(categoryInput.equals("vegetables") || categoryInput.equals("fruits") || categoryInput.equals("berries")))
            throw new InvalidKeyException("This category is invalid");
    }

    private void putDataIntoList(String itemInput) {
        if (itemInput.equals("vegetables")) {
            vegetablesList.add(itemInput);
        }
        if (itemInput.equals("fruits")) {
            fruitList.add(itemInput);
        }
        if (itemInput.equals("berries")) {
            berriesList.add(itemInput);
        }
    }

    public void fourthTask(){
        FileReader fileReader = new FileReader();
        FileWriter fw = new FileWriter();

        List<String> result = fileReader.readFromFile(initialStringPoolFilePath);
        Collections.reverse(result);

        fw.writeInFile(result, revertedStringPoolFilePath);

    }
}

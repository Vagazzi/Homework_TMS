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

        Map<String, List<String>> edibleItems = new LinkedHashMap<>();

        List<String> berriesList = new ArrayList<>();
        List<String> fruitList = new ArrayList<>();
        List<String> vegetablesList = new ArrayList<>();

        edibleItems.put("vegetables", vegetablesList);
        edibleItems.put("fruits", fruitList);
        edibleItems.put("berries", berriesList);

        List<String> scannerInput = new ArrayList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            for (int i = 0; i < 10; i++) {

                log.info("Enter the valid category");
                String inputCategory = scanner.nextLine();

                if (isValidCategory(inputCategory)) {
                    scannerInput.add(inputCategory);
                }

                log.info("Enter the item");
                String item = scanner.nextLine();
                scannerInput.add(item);

            }
        } catch (InvalidKeyException e) {
            log.info("{}", e.getMessage());
        }

        for (int i = 0; i < scannerInput.size(); i++) {
            if (scannerInput.get(i).equals("berries")) {
                berriesList.add(scannerInput.get(i + 1));
            }
            if (scannerInput.get(i).equals("vegetables")) {
                vegetablesList.add(scannerInput.get(i + 1));
            }
            if (scannerInput.get(i).equals("fruits")) {
                fruitList.add(scannerInput.get(i + 1));
            }
        }

        log.info("{}", edibleItems);

        log.info("{}", edibleItems.get("vegetables"));
        log.info("{}", edibleItems.get("fruits"));
        log.info("{}", edibleItems.get("berries"));

    }

    private static boolean isValidCategory(String categoryInput) throws InvalidKeyException {
        if (!(categoryInput.equals("vegetables") || categoryInput.equals("fruits") || categoryInput.equals("berries"))) {
            throw new InvalidKeyException("This category is invalid");
        }
        return true;
    }

    public void fourthTask() {
        FileReader fileReader = new FileReader();
        FileWriter fw = new FileWriter();

        List<String> result = fileReader.readFromFile(initialStringPoolFilePath);
        Collections.reverse(result);

        fw.writeInFile(result, revertedStringPoolFilePath);

    }
}

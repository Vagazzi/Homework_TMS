package org.example.homework.eleventh;

import lombok.extern.slf4j.Slf4j;
import org.example.homework.eleventh.interfaces.NumberValidator;
import org.example.homework.eleventh.validators.LengthValidator;
import org.example.homework.eleventh.validators.PrefixValidator;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@Slf4j
public class EleventhHometask {
    public static void main(String[] args) throws URISyntaxException {

        URI templatesURI = ClassLoader.getSystemResource("eleventhHometaskResources/templates.txt").toURI();
        URI validURI = ClassLoader.getSystemResource("eleventhHometaskResources/valid.txt").toURI();
        URI invalidURI = ClassLoader.getSystemResource("eleventhHometaskResources/invalid.txt").toURI();

        String filepath = Paths.get(templatesURI).toString();
        String validFilePath = Paths.get(validURI).toString();
        String invalidFilePath = Paths.get(invalidURI).toString();

        NumberValidator validator = new NumberValidator(List.of(new LengthValidator(), new PrefixValidator()));

        FileReader fileReader = new FileReader();
        FileWriter fileWriter = new FileWriter();

        List<String> readingResult = fileReader.readFromFile(filepath);
        Map<String, String> invalidNumbers = validator.checkError(readingResult);
        List<String> validResults = validator.getValidValues(readingResult, invalidNumbers);

        fileWriter.writeInFile(validResults, validFilePath);
        fileWriter.writeInFile(invalidNumbers, invalidFilePath);


    }

}

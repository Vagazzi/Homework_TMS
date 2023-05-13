package org.example.homework.eleventh;

import lombok.extern.slf4j.Slf4j;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Slf4j
public class FileWriter {
    public void writeInFile(List<String> values, String fileName){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(fileName))){
            for (String value : values) {
                pw.println(value);
            }
            log.info("Writing has been completed successfully!");
        }catch (IOException e){
            log.error("{}", e.getMessage());
        }
    }

    public void writeInFile(Map<String, String> values, String fileName){

        List<String> invalidValues = values.entrySet().stream()
                .map(stringEntry -> stringEntry.getKey() + "\t " + " - "+ stringEntry.getValue())
                .collect(Collectors.toList());

        writeInFile(invalidValues, fileName);
    }
}

package org.example.homework.eleventh.interfaces;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.homework.eleventh.validators.NumberError;
import org.example.homework.eleventh.validators.Validable;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


@Slf4j
@RequiredArgsConstructor
public class NumberValidator {

    private final List<Validable> validators;

    public Map<String, String> checkError(List<String> values) {

        return values.stream().collect(Collectors.toMap(Function.identity(), string ->  validators.stream()
                        .map(validable -> validable.validate(string))
                .collect(Collectors.toList())))
                .entrySet().stream()
                .filter(stringListEntry ->
                        stringListEntry.getValue().removeAll(Collections.singletonList(NumberError.NO_ERROR)))
                .filter(stringListEntry ->
                        !stringListEntry.getValue().isEmpty())
                .collect(Collectors.toMap(Map.Entry::getKey, stringListEntry ->
                        stringListEntry.getValue().stream()
                                .map(NumberError::getErrorMessage)
                                .collect(Collectors.joining(" "))));
    }

    public List<String> getValidValues(List<String> values, Map<String, String> invalidValues){
        values.removeAll(invalidValues.keySet());

        return values;

    }

}

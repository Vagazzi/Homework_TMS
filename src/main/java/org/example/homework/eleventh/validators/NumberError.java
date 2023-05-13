package org.example.homework.eleventh.validators;


import lombok.Getter;

@Getter
public enum NumberError {


    INVALID_LENGTH("Number length doesn't equal 15."),
    INVALID_PREFIX("Number length doesn't starts with 'docnum' or 'contract'."),

    NO_ERROR("OK");

    private final String errorMessage;
    NumberError(String s) {
        errorMessage = s;
    }
}

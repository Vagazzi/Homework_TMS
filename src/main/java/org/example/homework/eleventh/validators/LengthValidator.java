package org.example.homework.eleventh.validators;

public class LengthValidator implements Validable {

    @Override
    public NumberError validate(String number) {
        if (number.length() != 15)
            return NumberError.INVALID_LENGTH;

        return NumberError.NO_ERROR;
    }
}

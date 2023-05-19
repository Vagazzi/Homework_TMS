package org.example.homework.eleventh.validators;

public class PrefixValidator implements Validable{
    @Override
    public NumberError validate(String number) {
        if(!(number.startsWith("docnum") || number.startsWith("contract")))
            return NumberError.INVALID_PREFIX;

        return NumberError.NO_ERROR;
    }
}

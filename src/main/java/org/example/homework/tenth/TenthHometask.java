package org.example.homework.tenth;

import org.example.homework.ninth.MainTask;

import org.example.homework.tenth.Exceptions.InvalidEndingException;
import org.example.homework.tenth.Exceptions.SequenceException;

public class TenthHometask {
    public static void main(String[] args) {
        MainTask.initializeString(4, 's');

        try {
            isEqualToConditions();
        } catch (SequenceException e) {
            System.out.println(e);
        } catch (InvalidEndingException e) {
            System.out.println("Change your number, your exceptions" + e);
        }
    }
    private static void isEqualToConditions() throws SequenceException, InvalidEndingException {
        String doc = MainTask.getNumberDoc();

        if (doc.contains("555") || doc.contains("abc"))
            throw new SequenceException("This string contains illegal sequence(s)");

        if (!doc.endsWith("1a2b"))
            throw new InvalidEndingException("This numbers doesn't end with 1a2b sequence");
    }
}

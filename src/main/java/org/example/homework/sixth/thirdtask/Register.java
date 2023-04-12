package org.example.homework.sixth.thirdtask;

import org.example.homework.sixth.thirdtask.documents.Document;

import java.util.ArrayList;
import java.util.List;

public class Register {
    private List<Document> register = new ArrayList<>(10);
    private int initialPosition = 0;

    public void pushData(Document document) {
        register.add(document);
    }

    public void getInformation() {
        Document tempDocument;
        for (Document document : register) {
            System.out.println("------------------------------------------------------------");
            tempDocument = document;
            tempDocument.printInfo();
            System.out.println("------------------------------------------------------------");
        }
    }
}


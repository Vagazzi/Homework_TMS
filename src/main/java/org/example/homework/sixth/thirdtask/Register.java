package org.example.homework.sixth.thirdtask;

import org.example.homework.sixth.thirdtask.documents.Document;

import java.util.ArrayList;
import java.util.List;

public class Register {
    private List<Document> register = new ArrayList<>();

    public void pushData(Document document) {
        if (register.size() > 10) {
            System.out.println("Size of register is too big");
            return;
        } else {
            register.add(document);
        }
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


package org.example.homework.sixth.thirdtask.documents;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderForDelivering extends Document {

    private String typeOfProduct;
    private int countOfProduct;

    @Override
    public void printInfo() {
        System.out.println(
                "Number of document: " + numberOfDocument + "\n" +
                        "Date of document : " + dateOfDocument + "\n" +
                        "Type(s) of product: " + typeOfProduct + "\n" +
                        "Count of product: " + countOfProduct
        );
    }

    public OrderForDelivering(Calendar dateOfDocument, String numberOfDocument, String typeOfProduct, int countOfProduct) {
        this.dateOfDocument = dateOfDocument;
        this.numberOfDocument = numberOfDocument;
        this.typeOfProduct = typeOfProduct;
        this.countOfProduct = countOfProduct;
    }
}

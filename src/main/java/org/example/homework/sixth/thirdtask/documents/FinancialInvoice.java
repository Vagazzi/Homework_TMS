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

public class FinancialInvoice extends Document {

    private double finishSum;
    private String departmentCode;

    public FinancialInvoice(Calendar dateOfDocument, String numberOfDocument, double finishSum, String departmentCode) {
        this.dateOfDocument = dateOfDocument;
        this.numberOfDocument = numberOfDocument;
        this.finishSum = finishSum;
        this.departmentCode = departmentCode;
    }

    @Override
    public void printInfo() {
        System.out.println(
                "Number of document: " + numberOfDocument + "\n" +
                        "Date of document: " + dateOfDocument + "\n" +
                        "Finish sum for this month: " + finishSum + "\n" +
                        "Department code: " + departmentCode
        );
    }
}

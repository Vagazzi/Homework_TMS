package org.example.homework.sixth.thirdtask.documents;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContractWithEmployee extends Document {
    private Calendar initialContractDate;
    private Calendar finishContractDate;

    private String employeeCredentials;

    public ContractWithEmployee(Calendar dateOfDocument, String numberOfDocument, Calendar initialContractDate, Calendar finishContractDate, String employeeCredentials) {
        this.dateOfDocument = dateOfDocument;
        this.numberOfDocument = numberOfDocument;
        this.initialContractDate = initialContractDate;
        this.finishContractDate = finishContractDate;
        this.employeeCredentials = employeeCredentials;
    }


    @Override
    public void printInfo() {
        System.out.println(
                "Number of document: " + numberOfDocument + "\n" +
                        "Date of document: " + dateOfDocument + "\n" +
                        "Initial date of contract: " + initialContractDate + "\n" +
                        "Finish date of contract: " + finishContractDate + "\n" +
                        "Credentials of employee: " + employeeCredentials
        );
    }
}

package org.example.homework.sixth;

import org.example.homework.sixth.firsttask.AbstractFigure;
import org.example.homework.sixth.firsttask.Circle;
import org.example.homework.sixth.firsttask.Rectangle;
import org.example.homework.sixth.firsttask.Triangle;
import org.example.homework.sixth.secondtask.CEO;
import org.example.homework.sixth.secondtask.Employee;
import org.example.homework.sixth.secondtask.FinanceManager;
import org.example.homework.sixth.secondtask.Worker;
import org.example.homework.sixth.thirdtask.Register;
import org.example.homework.sixth.thirdtask.documents.ContractWithEmployee;
import org.example.homework.sixth.thirdtask.documents.Document;
import org.example.homework.sixth.thirdtask.documents.FinancialInvoice;
import org.example.homework.sixth.thirdtask.documents.OrderForDelivering;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SixthHomework {
    public static void main(String[] args) {

        calculateData();
        setPositions();
        documentFlow();
    }

    private static void calculateData() {

        AbstractFigure circle = new Circle(4);
        AbstractFigure anotherCircle = new Circle(5);
        AbstractFigure triangle = new Triangle(4, 5, 6);
        AbstractFigure anotherTriangle = new Triangle(6, 7, 8);
        AbstractFigure rectangle = new Rectangle(6, 10);

        ArrayList<AbstractFigure> figureList = new ArrayList<>(5);

        figureList.add(circle);
        figureList.add(triangle);
        figureList.add(rectangle);
        figureList.add(anotherCircle);
        figureList.add(anotherTriangle);

        double sum = 0.0d;
        for (AbstractFigure abstractFigure : figureList) {
            sum += abstractFigure.calculatePerimeter();

        }

        System.out.println("Sum of perimeters of these figures is: " + sum);

    }

    private static void setPositions() {
        Employee CEO = new CEO();
        Employee worker = new Worker();
        Employee financeManager = new FinanceManager();

        CEO.setEmployeePosition("CEO");
        worker.setEmployeePosition("Worker");
        financeManager.setEmployeePosition("Finance manager");

        System.out.println(CEO.getEmployeePosition());
        System.out.println(worker.getEmployeePosition());
        System.out.println(financeManager.getEmployeePosition());
    }



    private static void documentFlow() {

        Calendar dateOfDocument = new GregorianCalendar();
        dateOfDocument.set(Calendar.YEAR, 2017);
        dateOfDocument.set(Calendar.MONTH, 2);
        dateOfDocument.set(Calendar.DAY_OF_MONTH, 2);

        Calendar contractStart = new GregorianCalendar();
        contractStart.set(Calendar.YEAR, 2019);
        contractStart.set(Calendar.MONTH, 11);
        contractStart.set(Calendar.DAY_OF_MONTH, 14);

        Calendar contractFinish = new GregorianCalendar();
        contractStart.set(Calendar.YEAR, 2019);
        contractStart.set(Calendar.MONTH, 11);
        contractStart.set(Calendar.DAY_OF_MONTH, 14);

        Document invoice = new FinancialInvoice(dateOfDocument, "1",10000.44, "322");
        Document order = new OrderForDelivering(dateOfDocument, "2", "Pivo", 100000);
        Document contract = new ContractWithEmployee(dateOfDocument, "3", contractStart, contractFinish, "Жмышенко Валерий Альбертович");

        Register register = new Register();

        register.pushData(contract);
        register.pushData(invoice);
        register.pushData(order);
        register.getInformation();
    }

}

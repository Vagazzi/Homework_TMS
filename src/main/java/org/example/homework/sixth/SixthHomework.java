package org.example.homework.sixth;

import org.example.homework.sixth.firsttask.AbstractFigure;
import org.example.homework.sixth.firsttask.Circle;
import org.example.homework.sixth.firsttask.Rectangle;
import org.example.homework.sixth.firsttask.Triangle;

import java.util.ArrayList;

public class SixthHomework {
    public static void main(String[] args) {

        calculateData();

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
}

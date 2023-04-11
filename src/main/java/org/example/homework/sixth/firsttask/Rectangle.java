package org.example.homework.sixth.firsttask;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Rectangle extends AbstractFigure {

    private int a;
    private int b;

    @Override
    public double calculatePerimeter() {
        perimeter = (double) 2 * (a + b);
        System.out.println("Perimeter of this rectangle is: " + perimeter);
        return perimeter;
    }

    @Override
    public double calculateSquare() {
        square = a * b;
        System.out.println("Square of this rectangle is: " + square);
        return square;
    }
}

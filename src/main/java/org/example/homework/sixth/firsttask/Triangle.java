package org.example.homework.sixth.firsttask;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Triangle extends AbstractFigure {

    private int a;
    private int b;
    private int c;

    @Override
    public double calculatePerimeter() {
        perimeter = a + b + c;
        System.out.println("Perimeter of this triangle is: " + perimeter);
        return perimeter;
    }

    @Override
    public double calculateSquare() {   // формула Герона
        double p = (double) (a + b + c) / 2;
        square = Math.sqrt(p * ((p - a) * (p - b) * (p - c)));
        System.out.println("Square of this triangle is: " + square);
        return square;
    }
}

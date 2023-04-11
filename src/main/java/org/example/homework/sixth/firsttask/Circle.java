package org.example.homework.sixth.firsttask;


import lombok.AllArgsConstructor;


@AllArgsConstructor
public class Circle extends AbstractFigure {

    private int radius;

    @Override
    public double calculatePerimeter() {
        perimeter = radius * 2 * Math.PI;
        System.out.println("Perimeter of this circle is: " + perimeter);
        return perimeter;
    }

    @Override
    public double calculateSquare() {
        square = Math.pow(radius, 2) * Math.PI;
        System.out.println("Square of this circle is: " + square);
        return square;
    }


}

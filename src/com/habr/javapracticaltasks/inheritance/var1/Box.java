package com.habr.javapracticaltasks.inheritance.var1;

import java.util.ArrayList;
import java.util.List;

public class Box extends Shape {
    private final List<Shape> shapes = new ArrayList<>();
    private double totalVolume;

    public Box(double volume) {
        super(volume);
        totalVolume = volume;
    }

    public boolean add(Shape shape) {
        double shapeVolume = shape.getVolume();
        if (totalVolume >= shapeVolume) {
            shapes.add(shape);
            totalVolume -= shapeVolume;
            return true;
        }
        return false;
    }
}

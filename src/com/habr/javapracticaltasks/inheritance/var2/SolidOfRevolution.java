package com.habr.javapracticaltasks.inheritance.var2;

public abstract class SolidOfRevolution extends Shape {
    private final double radius;

    public SolidOfRevolution(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}

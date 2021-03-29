package com.habr.javapracticaltasks.inheritance.var1;

public class Cylinder extends SolidOfRevolution {
    private final double height;

    public Cylinder(double radius, double height) {
        super(Math.PI * Math.pow(radius, 2) * height, radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }
}

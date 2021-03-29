package com.habr.javapracticaltasks.inheritance.var2;

public class Cylinder extends SolidOfRevolution {
    private final double volume;
    private final double height;

    public Cylinder(double radius, double height) {
        super(radius);
        this.volume = Math.PI * Math.pow(radius, 2) * height;
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double getVolume() {
        return volume;
    }
}

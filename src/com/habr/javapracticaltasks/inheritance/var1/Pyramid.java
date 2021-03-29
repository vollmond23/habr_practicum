package com.habr.javapracticaltasks.inheritance.var1;

public class Pyramid extends Shape {
    private final double s;
    private final double h;

    public Pyramid(double s, double h) {
        super((1. / 3) * s * h);
        this.s = s;
        this.h = h;
    }

    public double getS() {
        return s;
    }

    public double getH() {
        return h;
    }
}

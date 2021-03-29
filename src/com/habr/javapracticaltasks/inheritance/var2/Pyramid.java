package com.habr.javapracticaltasks.inheritance.var2;

public class Pyramid extends Shape {
    private final double volume;
    private final double s;
    private final double h;

    public Pyramid(double s, double h) {
        this.volume = (1. / 3) * s * h;
        this.s = s;
        this.h = h;
    }

    public double getS() {
        return s;
    }

    public double getH() {
        return h;
    }

    @Override
    public double getVolume() {
        return volume;
    }
}

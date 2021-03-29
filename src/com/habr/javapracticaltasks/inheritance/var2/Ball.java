package com.habr.javapracticaltasks.inheritance.var2;

public class Ball extends SolidOfRevolution {
    private final double volume;

    public Ball(double radius) {
        super(radius);
        this.volume = (4. / 3) * Math.PI * Math.pow(radius, 3);
    }

    @Override
    public double getVolume() {
        return volume;
    }
}

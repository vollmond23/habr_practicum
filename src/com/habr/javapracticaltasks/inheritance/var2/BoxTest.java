package com.habr.javapracticaltasks.inheritance.var2;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BoxTest {
    private Ball ball;
    private Cylinder cylyinder;
    private Pyramid pyramid;
    private Box box;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        ball = new Ball(4.5);
        cylyinder = new Cylinder(2, 2);
        pyramid = new Pyramid(100, 100);
        box = new Box(1000);
    }

    @org.junit.jupiter.api.Test
    void add() {
        assertTrue(box.add(ball));
        assertTrue(box.add(cylyinder));
        assertFalse(box.add(pyramid));
    }
}
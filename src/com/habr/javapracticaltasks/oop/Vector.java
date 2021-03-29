/*
    https://habr.com/ru/post/440436/#20

    Создайте класс, который описывает вектор (в трёхмерном пространстве).

    У него должны быть:
    - конструктор с параметрами в виде списка координат x, y, z
    - метод, вычисляющий длину вектора. Корень можно посчитать с помощью Math.sqrt():
    - метод, вычисляющий скалярное произведение:
    - метод, вычисляющий векторное произведение с другим вектором:
    - метод, вычисляющий угол между векторами (или косинус угла): косинус угла между векторами равен скалярному произведению векторов, деленному на произведение модулей (длин) векторов:
    - методы для суммы и разности:
    - статический метод, который принимает целое число N, и возвращает массив случайных векторов размером N.

    Если метод возвращает вектор, то он должен возвращать новый объект, а не менять базовый. То есть, нужно реализовать шаблон "Неизменяемый объект"
 */
package com.habr.javapracticaltasks.oop;

public class Vector {
    private final double x;
    private final double y;
    private final double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double scalar(Vector anotherVector) {
        return x * anotherVector.x + y * anotherVector.y + z * anotherVector.z;
    }

    public Vector vectorProduct(Vector anotherVector) {
        return new Vector(y * anotherVector.z - z * anotherVector.y,
                z * anotherVector.x - x * anotherVector.z,
                x * anotherVector.y - y * anotherVector.x);
    }

    public double cos(Vector anotherVector) {
        return scalar(anotherVector) / (length() * anotherVector.length());
    }

    public Vector sum(Vector anotherVector) {
        return new Vector(x + anotherVector.x, y + anotherVector.y, z + anotherVector.z);
    }

    public Vector subtract(Vector anotherVector) {
        return new Vector(x - anotherVector.x, y - anotherVector.y, z - anotherVector.z);
    }

    public static Vector[] vectors(int n) {
        Vector[] array = new Vector[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Vector(Math.random(), Math.random(), Math.random());
        }
        return array;
    }
}

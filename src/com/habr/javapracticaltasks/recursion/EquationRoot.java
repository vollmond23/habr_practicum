/*
    https://habr.com/ru/post/440436/#31

    Найдите корень уравнения
    на отрезке [0; 10] с точностью по x не хуже, чем 0.001. Известно, что на этом промежутке корень единственный.
    Используйте для этого метод деления отрезка пополам (и рекурсию).
 */
package com.habr.javapracticaltasks.recursion;

public class EquationRoot {
    static double epsilon = 0.001;

    public static void main(String[] args) {
        System.out.println("Solution with cycles: " + cyclesRootSearch(0, 10));
        System.out.println("Solution with recursive: " + recursiveRootSearch(0, 10));
    }

    public static double equation(double x) {
        return Math.cos(Math.pow(x, 5)) + Math.pow(x, 4) - 345.3 * x - 23;
    }

    public static double cyclesRootSearch(double left, double right) {
        do {
            double leftEquation = equation(left);
            double middle = (left + right) / 2;
            double middleEquation = equation(middle);
            if (leftEquation * middleEquation < 0) {
                right = middle;
            } else {
                left = middle;
            }
        } while (right - left >= epsilon);
        return (left + right) / 2;
    }

    public static double recursiveRootSearch(double left, double right) {
        double middle = (left + right) / 2;
        if (right - left <= epsilon || middle == left || middle == right) {
            return middle;
        }
        if (equation(left) * equation(middle) < 0) {
            return recursiveRootSearch(left, middle);
        } else {
            return recursiveRootSearch(middle, right);
        }
    }
}

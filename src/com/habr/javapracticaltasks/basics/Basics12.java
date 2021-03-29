/*
    https://habr.com/ru/post/440436/#12

    Напишите программу, которая выводит на консоль простые числа в промежутке от [2, 100].
    Используйте для решения этой задачи оператор "%" (остаток от деления) и циклы.
 */
package com.habr.javapracticaltasks.basics;

public class Basics12 {
    private static final int[] simpleNumbers = new int[101];

    public static void main(String[] args) {
        for (int i = 1; i < simpleNumbers.length; i++) {
            simpleNumbers[i] = i;
        }

        for (int i = 2; i < simpleNumbers.length; i++) {
            for (int j = simpleNumbers.length - 1; j > i; j--) {
                if (simpleNumbers[j] != 0 && simpleNumbers[i] != 0 && simpleNumbers[j] % simpleNumbers[i] == 0) {
                    simpleNumbers[j] = 0;
                }
            }
        }

        for (int i = 2; i < simpleNumbers.length; i++) {
            if (simpleNumbers[i] != 0) {
                System.out.println(simpleNumbers[i]);
            }
        }
    }
}

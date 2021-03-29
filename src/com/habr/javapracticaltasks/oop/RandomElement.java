/*
    https://habr.com/ru/post/440436/#21

    Напишите класс, конструктор которого принимает два массива: массив значений и массив весов значений.
    Класс должен содержать метод, который будет возвращать элемент из первого массива случайным образом, с учётом его веса.
    Пример:
    Дан массив [1, 2, 3], и массив весов [1, 2, 10].
    В среднем, значение «1» должно возвращаться в 2 раза реже, чем значение «2» и в десять раз реже, чем значение «3».
 */
package com.habr.javapracticaltasks.oop;

import java.util.HashMap;
import java.util.Map;

public class RandomElement {
    public static void main(String[] args) {
        Map<Integer, Integer> counters = new HashMap<>();
        for (int i = 0; i < 1_000_000; i++) {
            int randomElement = getElement(new int[]{1, 2, 3}, new int[]{1, 2, 10});
            counters.merge(randomElement, 1, Integer::sum);
        }
        System.out.println(counters);
    }

    public static int getElement(int[] elements, int[] weights) {
        if (elements.length != weights.length) {
            throw new IllegalArgumentException("Arrays must be the same length");
        }
        int allWeights = 0;
        for (int i = 0; i < weights.length; i++) {
            allWeights += weights[i];
        }
        double randomValue = Math.random() * allWeights;
        int sumWeights = 0;
        for (int i = 0; i < weights.length; i++) {
            sumWeights += weights[i];
            if (randomValue < sumWeights) {
                return elements[i];
            }
        }
        return -1;
    }
}

/*
    https://habr.com/ru/post/440436/#11

    Реализуйте алгоритм сортировки пузырьком для сортировки массива
 */
package com.habr.javapracticaltasks.basics;

import java.util.Arrays;
import java.util.Random;

public class Basics11 {
    private static final int LENGTH = 10;

    public static void main(String[] args) {
        int[] array = new int[LENGTH];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(20);
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(array));
    }
}

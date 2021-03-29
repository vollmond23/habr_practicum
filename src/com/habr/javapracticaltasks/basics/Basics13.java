/*
    https://habr.com/ru/post/440436/#13

    Дан массив целых чисел и ещё одно целое число. Удалите все вхождения этого числа из массива (пропусков быть не должно).
 */
package com.habr.javapracticaltasks.basics;

import java.util.Arrays;
import java.util.Random;

public class Basics13 {

    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(5);
        }

        System.out.println(Arrays.toString(array));

        int number = random.nextInt(5);
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                System.arraycopy(array, i + 1, array, i, array.length - 1 - i);
                count++;
                if (array[i] == number) {
                    i--;
                }
            }
        }

        System.out.println("number = " + number);
        System.out.println(Arrays.toString(Arrays.copyOf(array, array.length - count)));
    }
}

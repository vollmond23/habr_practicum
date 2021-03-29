/*
    https://habr.com/ru/post/440436/#30

    Напишите метод, который проверяет, входит ли в массив заданный элемент или нет.
    Используйте перебор и двоичный поиск для решения этой задачи.
    Сравните время выполнения обоих решений для больших массивов (например, 100000000 элементов).
 */
package com.habr.javapracticaltasks.recursion;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {

    public static void main(String[] args) {
        int length = 100_000_000;
        int searchValue = 25_000_000;
        int[] array = getSortedArray(length);
        long start = System.currentTimeMillis();
        System.out.println(directSearch(array, searchValue));
        System.out.println("Time for direct search: " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        System.out.println(binarySearch(array, searchValue));
        System.out.println("Time for binary search: " + (System.currentTimeMillis() - start));
    }

    private static int[] getSortedArray(int length) {
        int[] array = new int[length];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(length);
        }
        Arrays.sort(array);
        return array;
    }

    private static int directSearch(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    private static int binarySearch(int[] array, int value) {
        return binarySearchHelper(array, 0, array.length - 1, value);
    }

    private static int binarySearchHelper(int[] array, int left, int right, int value) {
        int result = -1;
        if (right < left) {
            return result;
        }
        int middle = (left + right) / 2;
        if (array[middle] == value) {
            return middle;
        }
        if (value < array[middle]) {
            result = binarySearchHelper(array, left, middle - 1, value);
        } else {
            result = binarySearchHelper(array, middle + 1, right, value);
        }
        return result;
    }
}

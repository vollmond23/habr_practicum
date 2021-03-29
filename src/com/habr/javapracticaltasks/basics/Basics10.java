/*
    https://habr.com/ru/post/440436/#10

    Заполните массив случайным числами и выведете максимальное, минимальное и среднее значение.
    Для генерации случайного числа используйте метод Math.random(), который возвращает значение в промежутке [0, 1].
 */
package com.habr.javapracticaltasks.basics;

public class Basics10 {
    public static void main(String[] args) {
        int size = 13;
        int[] storage = new int[size];
        for (int i = 0; i < storage.length; i++) {
            storage[i] = (int) (Math.random() * 100);
        }
        int min = storage[0];
        int max = min;
        int sum = 0;
        for (int element : storage) {
            sum += element;
            if (element < min) {
                min = element;
            }
            if (element > max) {
                max = element;
            }
        }
        System.out.print("Array: ");
        for (int element : storage) {
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.println("Min element: " + min);
        System.out.println("Max element: " + max);
        System.out.println("Avg element: " + (double) sum / size);
    }
}

/*
    https://habr.com/ru/post/440436/#22

    Еще одна задача, которую я часто даю — реализация связного списка. Её можно давать в самом простом виде
    (реализовать только add() и get()), а можно попросить реализовать java.util.List.
 */
package com.habr.javapracticaltasks.oop;

public class MyList<E> {
    private int size;
    Node<E> root;

    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>();
        for (int i = 0; i < 10; i++) {
            myList.add(new Node<>(i));
        }
        System.out.println(myList);
        System.out.println(myList.get(4));
        myList.remove(1);
        System.out.println(myList);
        myList.remove(9);
        System.out.println(myList);
    }

    public MyList() {
        size = 0;
    }

    public void add(Node<E> node) {
        if (root == null) {
            root = node;
        } else {
            Node<E> lastNode = getNodeBy(size - 1);
            lastNode.next = node;
        }
        size++;
    }

    public E get(int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return getNodeBy(index).value;
    }

    public void remove(E value) {
        Node<E> node = root;
        if (root.value.equals(value)) {
            root = node.next;
            node.next = null;
        } else {
            Node<E> prev = root;
            node = node.next;
            Node<E> next = node.next;
            while (next != null) {
                if (node.value.equals(value)) {
                    prev.next = next;
                }
                prev = node;
                node = node.next;
                next = node.next;
            }
            if (node.value.equals(value)) {
                prev.next = null;
            }
        }
    }

    private Node<E> getNodeBy(int index) {
        Node<E> cursor = root;
        if (index == 0) return root;
        for (int i = 0; i < index; i++) {
            cursor = cursor.next;
        }
        return cursor;
    }

    private Node<E> getNodeBy(E value) {
        Node<E> cursor = root;
        do {
            if (cursor.value.equals(value)) {
                return cursor;
            };
        } while (cursor.next != null);
        return null;
    }

    @Override
    public String toString() {
        Node<E> cursor = root;
        StringBuilder sb = new StringBuilder("MyList{");
        int i = 0;
        while (cursor != null){
            sb.append("(").append(i++).append("=").append(cursor.value).append(")");
            cursor = cursor.next;
        }
        sb.append("}");
        return sb.toString();
    }

    private static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value) {
            this.value = value;
            next = null;
        }
    }
}

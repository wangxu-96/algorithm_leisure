package com.at.interview.common;

/**
 * Node define
 * @param <T>
 */
public class Node<T> {
    private final T value;
    private Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public static <T> void printLinkedList(Node<T> head){
        while (head != null){
            System.out.println(head.getValue());
            System.out.print(" ");
            head=head.getNext();
        }
        System.out.println();
    }
}

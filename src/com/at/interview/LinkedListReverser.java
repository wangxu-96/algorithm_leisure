package com.at.interview;

import com.at.interview.common.Node;

import java.util.ArrayList;
import java.util.Arrays;

public class LinkedListReverser {
    public <T>Node<T> reverseLinkedList(Node<T> head){
        if (head==null||head.getNext()==null){
            return head;
        }
        Node<T> newHead = reverseLinkedList(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return newHead;
    }
    public static void main(String[] args){
        LinkedListCreator creator=new LinkedListCreator();
        LinkedListReverser reverser=new LinkedListReverser();
        Node.printLinkedList(reverser.reverseLinkedList(creator.createLinkedList(new ArrayList<>())));
        Node.printLinkedList(reverser.reverseLinkedList(creator.createLinkedList(Arrays.asList(1))));
        Node.printLinkedList(reverser.reverseLinkedList(creator.createLinkedList(Arrays.asList(1,2,3,4,5))));
    }
}

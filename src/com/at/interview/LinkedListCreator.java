package com.at.interview;

import com.at.interview.common.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * create linked list
 */
public class LinkedListCreator {

    /**
     * create a linked list
     * @param data the data to create the list
     * @param <T>
     * @return head of the linked list.The returned linked list
     * ends with last node with getNext()=null.
     */
    public <T>Node<T> createLinkedList(List<T> data){
        if (data.isEmpty()){
            return null;
        }
        Node<T> firstNode=new Node<T>(data.get(0));
        firstNode.setNext(createLinkedList(data.subList(1,data.size())));
        return firstNode;
    }

    public static void main(String[] args){
        LinkedListCreator creator=new LinkedListCreator();

        Node.printLinkedList(creator.createLinkedList(new ArrayList<>()));
        Node.printLinkedList(creator.createLinkedList(Arrays.asList(1)));
        Node.printLinkedList(creator.createLinkedList(Arrays.asList(1,2,3,4,5)));
    }
}

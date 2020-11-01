package com.at.wangxu.geektime.week1;

/**
 * 641. 设计循环双端队列
 * 
 * 设计实现双端队列。
你的实现需要支持以下操作：

MyCircularDeque(k)：构造函数,双端队列的大小为k。
insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
isEmpty()：检查双端队列是否为空。
isFull()：检查双端队列是否满了。
示例：

MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
circularDeque.insertLast(1);			        // 返回 true
circularDeque.insertLast(2);			        // 返回 true
circularDeque.insertFront(3);			        // 返回 true
circularDeque.insertFront(4);			        // 已经满了，返回 false
circularDeque.getRear();  				// 返回 2
circularDeque.isFull();				        // 返回 true
circularDeque.deleteLast();			        // 返回 true
circularDeque.insertFront(4);			        // 返回 true
circularDeque.getFront();				// 返回 4
 
提示：

所有值的范围为 [1, 1000]
操作次数的范围为 [1, 1000]
请不要使用内置的双端队列库。
 */
public class MyCircularDeque {

    static class Node {
        int val;
        Node next;
        Node pre;
        
        public Node(int value) {
            this.val = value;
        }
    }
    int capacity = 0;
    int size = 0;
    Node tail = null;
    Node head = null;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        capacity = k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {

        if (size >= capacity) {
            return false;
        }
        if (head == null) {
            head = new Node(value);
            tail = head;
        }else {
            Node node = new Node(value);
            node.next = head;
            head.pre = node;
            head = node;
        }
        size ++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (size >= capacity) {
            return false;
        }
        if (tail == null) {
            tail = new Node(value);
            head = tail;
        }else {
            Node node = new Node(value);
            tail.next = node;
            node.pre = tail;
            tail = node;
        }
        size ++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (size == 0) {
            return false;
        }else if (size == 1){
            head = null;
            tail = null;
            size --;
            return true;
        }

        head = head.next;
        head.pre.next = null;
        head.pre = null;

        size --;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (size == 0) {
            return false;
        }else if (size == 1) {
            tail = null;
            head = null;
            size --;
            return true;
        }

        tail = tail.pre;
        tail.next.pre = null;
        tail.next = null;
        size --;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if (size == 0) {
            return -1;
        }
        return head.val;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if (size == 0) {
            return -1;
        }
        return tail.val;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        MyCircularDeque deque = new MyCircularDeque(8);
        deque.insertFront(5);
        System.out.println(deque.getFront());
        System.out.println(deque.isEmpty());
        System.out.println(deque.deleteFront());
        System.out.println(deque.insertLast(3));
        System.out.println(deque.getRear());
        System.out.println(deque.insertLast(7));
        System.out.println(deque.insertFront(7));
        System.out.println(deque.deleteLast());
        System.out.println(deque.insertLast(4));
        System.out.println(deque.isEmpty());
    }
}

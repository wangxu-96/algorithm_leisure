package com.at.wangxu.competition;

import java.util.LinkedList;

public class FrontMiddleBackQueue {
    LinkedList<Integer> list = new LinkedList<>();
    public FrontMiddleBackQueue() {

    }
    
    public void pushFront(int val) {
        list.addFirst(val);
    }
    
    public void pushMiddle(int val) {
        list.add(list.size()/2,val);
    }
    
    public void pushBack(int val) {
        list.addLast(val);
    }
    
    public int popFront() {
        if (list.size() == 0) return -1;
        return  list.pollFirst();
    }
    
    public int popMiddle() {
        if (list.size() == 0) return -1;
        if (list.size() % 2 == 1) {
            int mid = list.remove(list.size()/2);
            return mid;
        }else {
            int mid = list.remove(list.size()/2 - 1);
        return mid;
        }
        
    }
    
    public int popBack() {
        if (list.size() == 0) return -1;
        return list.pollLast();
    }

    public static void main(String[] args) {
        FrontMiddleBackQueue q = new FrontMiddleBackQueue();
q.pushFront(1);   // [1]
q.pushBack(2);    // [1, 2]
q.pushMiddle(3);  // [1, 3, 2]
q.pushMiddle(4);  // [1, 4, 3, 2]
q.popFront();     // 返回 1 -> [4, 3, 2]
q.popMiddle();    // 返回 3 -> [4, 2]
q.popMiddle();    // 返回 4 -> [2]
q.popBack();      // 返回 2 -> []
q.popFront();     // 返回 -1 -> [] （队列为空）
    }

}

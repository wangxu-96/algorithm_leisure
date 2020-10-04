package com.at.wangxu.newcoder;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目描述
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class PrintListFromTailToHead {

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null)
            return new ArrayList<>();
        if (listNode.next == null)
            return new ArrayList<>(listNode.val);
        ListNode p1 = listNode;
        ListNode p2 = listNode.next;
        ListNode p3;
        while (p2 != null){
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        listNode.next = null;
        listNode = p1;
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null){
            list.add(listNode.val);
            listNode = listNode.next;
        }
        return list;
    }
}



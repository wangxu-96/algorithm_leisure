package com.at.wangxu.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ReorderList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public void reorderList(ListNode head) {
        List<ListNode> listNodeList = new LinkedList<>();

        while (head != null){
            listNodeList.add(head);
            ListNode temp = head;

            head = head.next;
            temp.next = null;
        }

        int s = 0,l = listNodeList.size() - 1;

        while (s < l){
            listNodeList.get(s ++).next = listNodeList.get(l);
            if (listNodeList.get(l) != listNodeList.get(s))
                listNodeList.get(l --).next = listNodeList.get(s);
        }
    }


    public void reorderList1(ListNode head) {

        if (head == null || head.next == null)return;
        ListNode slow = head;
        ListNode fast = head;
        //find middle
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse list
        ListNode p2 = reverse(slow.next);
        slow.next = null;

        ListNode p1 = head;

        //merge p2,p1
        while (p1 != null && p2 != null){
            ListNode p3 = p1.next;
            ListNode p4 = p2.next;
            p1.next = p2;
            p2.next = p3;

            p1 = p3;
            p2 = p4;
        }

    }

    public ListNode reverse(ListNode listNode){
        if (listNode == null || listNode.next == null)
            return listNode;
        ListNode p1 = listNode;
        ListNode p2 = listNode.next;
        ListNode p3 = null;
        while (p2 != null){
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        listNode.next = null;
        return p1;
    }




    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
//        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(4);
//        node.next.next.next.next = new ListNode(5);

        new ReorderList().reorderList1(node);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}



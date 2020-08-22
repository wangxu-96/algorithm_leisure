package com.at.wangxu.newcoder;

/**
 * 题目描述
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode p3 = null;

        while (p2 != null){
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        head.next = null;
        return p1;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode temp = node;
        temp.next = new ListNode(2);
        temp = temp.next;
        temp.next = new ListNode(3);
        temp = temp.next;
        temp.next = new ListNode(4);
        temp = temp.next;
        temp.next = new ListNode(5);
        temp = temp.next;
        ListNode node1 = new ReverseList().ReverseList(node);
        while (node1 != null){
            System.out.println(node1.val);
            node1 = node1.next;
        }
    }


}

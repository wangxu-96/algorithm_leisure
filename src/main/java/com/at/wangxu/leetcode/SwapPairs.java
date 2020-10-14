package com.at.wangxu.leetcode;

/**
 * 24. 两两交换链表中的节点
 * <p>
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class SwapPairs {

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

    public ListNode swapPairs(ListNode head) {

        ListNode p1 = head;
        if (p1 == null)
            return null;
        ListNode p2 = head.next;
        if (p2 == null) {
            return p1;
        }
        ListNode p3 = p2.next;
        p2.next = p1;

        if (p3 != null) {
            p1.next = swapPairs(p3);
        } else {
            p1.next = null;
        }
        return p2;
    }


    public static void main(String[] args) {
        SwapPairs swapPairs = new SwapPairs();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        swapPairs.swapPairs(node);
    }

}

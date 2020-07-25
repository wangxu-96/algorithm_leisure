package com.at.wangxu.leetcode;

import java.util.Stack;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例：
 * <p>
 * 给你这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明：
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class ReverseKGroup {


    /**
     * 1。先将k个节点逆序(利用栈的特性)，如果k比剩余的节点个数大，则不需要逆序，直接返回
     * 2。递归执行步骤1
     *
     * @param head head
     * @param k    k
     * @return ListNode
     */
    public ListNode reverseKGroupByStack(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        for (int i = 0; i < k; i++) {
            if (head != null) {
                stack.push(head);
            } else {
                return temp;
            }
            head = head.next;
        }

        ListNode first = stack.pop();
        ListNode res = first;
        for (int i = 0; i < k - 1; i++) {
            first.next = stack.pop();
            first = first.next;
        }
        first.next = reverseKGroupByStack(head, k);
        return res;
    }

    /**
     * 逆序链表
     * 先判断链表长度是否大于k，不大于直接返回
     * 若大于，则进行k-1次逆序，每次逆序一个节点。（因为每次逆序都会涉及到2个节点，所以只需要逆序k-1次）
     * 最后返回逆序后的head，将其设置为前一次逆序的next（递归实现）
     * @param head head
     * @param k k
     * @return ListNode
     */
    public ListNode reverseKGroupByPoint(ListNode head, int k) {
        int length = 0;
        ListNode tempNode = head;
        //ListNode length
        while (tempNode != null){
            length ++;
            tempNode = tempNode.next;
        }
        if (length / k == 0)
            return head;
        ListNode t = null;
        ListNode current = head;
        ListNode next = head.next;
        for (int i = 0; i < k -1; i++) {
            t = next.next;
            next.next = current;
            current = next;
            next = t;
        }
        head.next = reverseKGroupByPoint(next, k);
        return current;
    }

    public static void main(String[] args) {
        ReverseKGroup kGroup = new ReverseKGroup();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        ListNode listNode = kGroup.reverseKGroupByPoint(head, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
        System.out.println("reverseKGroupByPoint: cost time: " + (endTime-startTime));
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        long startTime1 = System.currentTimeMillis();
        long endTime1 = System.currentTimeMillis();
        ListNode listNode1 = kGroup.reverseKGroupByStack(head1, 2);
        while (listNode1 != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
        System.out.println("reverseKGroupByPoint: cost time: " + (endTime1-startTime1));

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

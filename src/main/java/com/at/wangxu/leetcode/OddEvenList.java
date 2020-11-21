package com.at.wangxu.leetcode;

/**
 * 328. 奇偶链表
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode firstEven = even;
        while (odd != null && even != null && odd.next != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }
        odd.next = firstEven;
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        // node.next.next.next.next = new ListNode(5);
        OddEvenList oddEvenList = new OddEvenList();
        ListNode result = oddEvenList.oddEvenList(node);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

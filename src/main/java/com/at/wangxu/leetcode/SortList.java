package com.at.wangxu.leetcode;

/**
 * 148. 排序链表 https://leetcode-cn.com/problems/sort-list/
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        return mergetSort(head, null);
    }

    private ListNode mergetSort(ListNode head, ListNode tail) {
        if (head == null)
            return head;
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = mergetSort(head, mid);
        ListNode list2 = mergetSort(mid, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;

    }

    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode res = dummyNode;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                dummyNode.next = node1;
                node1 = node1.next;
            } else {
                dummyNode.next = node2;
                node2 = node2.next;
            }
            dummyNode = dummyNode.next;
        }

        if (node1 == null)
            dummyNode.next = node2;
        else if (node2 == null)
            dummyNode.next = node1;

        return res.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        SortList sort = new SortList();
        ListNode res = sort.sortList(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}

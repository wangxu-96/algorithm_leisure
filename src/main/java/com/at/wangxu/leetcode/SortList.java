package com.at.wangxu.leetcode;

/**
 * 148. 排序链表 https://leetcode-cn.com/problems/sort-list/
 */
public class SortList {

    public ListNode sortList(ListNode head) {

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

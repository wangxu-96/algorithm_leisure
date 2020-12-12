package com.at.wangxu.competition;

import com.at.wangxu.newcoder.Merge.ListNode;

/**
 * 5558. 合并两个链表
 */
public class MergeInBetween {
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

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummy = list1;
        int sub = b - a;
        while (a -- > 0) {
            list1 = list1.next;
        }
        ListNode delHead = list1.next;
        while(sub -- > 0) {
            delHead = delHead.next;
        }
        list1.next = list2;
        while (list2.next != null) {
            list2 = list2.next;
        }
        list2.next = delHead;
        return dummy;
        
    }

}

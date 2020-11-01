package com.at.wangxu.geektime.week1;

/**
 * 21. 合并两个有序链表
 */
public class MergeTwoLists {
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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                temp.next = l2;
                break;
            } else if (l2 == null) {
                temp.next = l1;
                break;
            }

            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;

        }

        return dummyNode.next;
    }
}

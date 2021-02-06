package com.at.wangxu.competition;

import java.util.List;

public class SwapNodes {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapNodes(ListNode head,int k) {
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode dummyNode = res;
        int temp = k;
        while (temp > 1 && dummyNode != null) {
            dummyNode = dummyNode.next;
            temp --;
        }
        ListNode fast = res;
        ListNode slow = res;
        int step = 0;
        while (step <= k  && fast != null) {
            fast = fast.next;
            step ++;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        System.out.println(dummyNode.val + " \t" + slow.val);
        swap(dummyNode,slow);
        return res.next;
    }

    private void swap(ListNode p,ListNode q) {
        if (p == q) return;
        if (p.next == q) {
            swapAdjacent(p,q);
            return;
        }
        if (q.next == p) {
            swapAdjacent(q,p);
            return;
        }
        ListNode pNext = p.next;
        ListNode qNext = q.next;
        ListNode qNextNext = qNext == null ? null : qNext.next;
        ListNode pNextNext = pNext == null ? null : pNext.next;
        p.next = q.next;
        if (qNext != null && qNext.next != pNextNext) {
            qNext.next = pNextNext;
        }
        q.next = pNext;
        if (pNext != null && pNext.next != qNextNext) {
            pNext.next = qNextNext;
        }
    }

    private void swapAdjacent(ListNode prev,ListNode next) {
        ListNode preNext = prev.next ;
        ListNode nextNext = next.next;
        ListNode nextNextNext = nextNext == null ? null : nextNext.next;
        prev.next = nextNext;
        nextNext.next = preNext;
        preNext.next = nextNextNext;
    }

    public static void main(String[] args) {
        SwapNodes swapNodes = new SwapNodes();
        ListNode listNode = new ListNode(100);
        listNode.next = new ListNode(90);
        swapNodes.swapNodes(listNode, 2);
    }
}

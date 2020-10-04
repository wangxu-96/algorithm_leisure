package com.at.wangxu.newcoder;

/**
 * 题目描述
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Merge {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode merge(ListNode list1,ListNode list2) {
        ListNode node = new ListNode(-1);
        ListNode temp = node;
        while (list1 != null || list2 != null){
            if (list1 == null){
                temp.next = new ListNode(list2.val);
                list2 = list2.next;
            }else if (list2 == null){
                temp.next = new ListNode(list1.val);
                list1 = list1.next;
            }else if (list1.val <= list2.val){
                temp.next = new ListNode(list1.val);
                list1 = list1.next;
            }else {
                temp.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            temp = temp.next;
        }
        return node.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(3);

        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(4);

        ListNode merge = new Merge().merge(node, listNode);
        while (merge != null){
            System.out.println(merge.val);
            merge = merge.next;
        }
    }
}

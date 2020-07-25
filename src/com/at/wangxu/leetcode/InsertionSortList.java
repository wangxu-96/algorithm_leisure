package com.at.wangxu.leetcode;

/**
 * 对链表进行插入排序
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 */
public class InsertionSortList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode insertionSortList(ListNode head){
        if (head == null)
            return null;
        ListNode dummyNode = new ListNode(Integer.MIN_VALUE),pre;
        dummyNode.next = head;

        while (head.next != null){

            if (head.val <= head.next.val){
                head = head.next;
                continue;
            }
            pre = dummyNode;

            while (pre.next.val < head.next.val){
                pre = pre.next;
            }

            //将current插入到pre与head之间
            ListNode curr = head.next;
            head.next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        InsertionSortList sortList = new InsertionSortList();

        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        ListNode listNode = sortList.insertionSortList(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

}

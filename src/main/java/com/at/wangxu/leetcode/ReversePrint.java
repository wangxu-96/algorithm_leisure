package com.at.wangxu.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * /**
 *  * Definition for singly-linked list.
 *  * public class ListNode {
 *  *     int val;
 *  *     ListNode next;
 *  *     ListNode(int x) { val = x; }
 *  * }
 *
 */
public class ReversePrint {

    // public int[] reversePrint(ListNode head) {
    //     Stack<Integer> stack = new Stack<>();

    //     while (head != null){
    //         stack.push(head.val);
    //         head = head.next;
    //     }
    //     int size = stack.size();
    //     int[] result = new int[size];
    //     for (int i = 0; i < size; i++) {
    //         result[i] = stack.pop();
    //     }
    //     return result;
    // }

    public int[] reversePrint(ListNode head) {
        Deque<ListNode> list = new LinkedList<>();

        dfs(head, list);
        int[] ints = new int[list.size()];

        int index = 0;
        for (int i : ints) {
            ints[index ++] = list.removeFirst().val;
        }
        return ints;
    }

    public void dfs(ListNode hNode,Deque<ListNode> list) {
        if (hNode == null) return;
        list.addFirst(hNode);
        dfs(hNode.next, list);
    }

    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        node.next = new ListNode(3);
        node.next.next = new ListNode(2);

        System.out.println(Arrays.toString(new ReversePrint().reversePrint(node)));
    }


    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}

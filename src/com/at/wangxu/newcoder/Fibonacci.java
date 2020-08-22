package com.at.wangxu.newcoder;

import java.util.HashMap;
import java.util.Map;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * n<=39
 */
public class Fibonacci {

    public int Fibonacci(int n) {
        if (n == 0)
            return 0;
        int a = 0;
        int b = 1;
        int temp;
        for (int i = 2; i <= n; i++) {
            temp = a;
            a = b;
            b +=temp;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(new Fibonacci().Fibonacci(2));
        System.out.println(new Fibonacci().Fibonacci(3));
        System.out.println(new Fibonacci().Fibonacci(4));
        System.out.println(new Fibonacci().Fibonacci(5));
        System.out.println(new Fibonacci().Fibonacci(6));
    }

    /**
     * 输入一个链表，输出该链表中倒数第k个结点。
     */
    public static class FindKthToTail {
        static class ListNode {
            int val;
            ListNode next = null;

            ListNode(int val) {
                this.val = val;
            }
        }

        public ListNode FindKthToTail(ListNode head, int k) {
            int size = 0;
            Map<Integer, ListNode> map = new HashMap<>();
            int index = 0;
            while (head != null){
                map.put(index,head);
                index ++;
                size ++;
                head = head.next;
            }

            return map.get(size - k);
        }

        /**
         * p先走k步,然后p,q一起走,直到p到头,q则是倒数第k个节点
         * @param head head
         * @param k k
         * @return ListNode
         */
        public ListNode findKthToTail(ListNode head, int k){
            ListNode p, q;
            p = q = head;
            int i = 0;
            for (; p != null; i++) {
                if (i >= k)
                    q = q.next;
                p = p.next;
            }
            return i < k ? null : q;
        }

        public static void main(String[] args) {
            ListNode node = new ListNode(1);
            ListNode temp = node;
            temp.next = new ListNode(2);
            temp = temp.next;
            temp.next = new ListNode(3);
            temp = temp.next;
            temp.next = new ListNode(4);
            temp = temp.next;
            temp.next = new ListNode(5);
            temp = temp.next;
            temp.next = new ListNode(6);
            ListNode node1 = new FindKthToTail().FindKthToTail(node, 3);
            while (node1 != null){
                System.out.println(node1.val);
                node1 = node1.next;
            }

        }
    }
}

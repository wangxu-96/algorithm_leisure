package com.at.leetcode;

/**
 * 两数相加
 */
public class AddTwoNumbers {

    public static void main(String[] args){
        ListNode l1=new ListNode(2);
        l1.next=new ListNode(4);
        l1.next.next=new ListNode(3);
        ListNode l2=new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);
        ListNode returnList=addTwoNumbers(l1,l2);
        while (returnList!=null){
            System.out.println(returnList.val);
            returnList=returnList.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode index = dummy;
        int flag =0;//进位标识
        while(l1 != null || l2 !=null){
            int l1_val = l1 ==null? 0:l1.val;
            int l2_val = l2 ==null? 0:l2.val;
            int sum = l1_val + l2_val + flag;
            if (sum >= 10)
                flag = 1;
            else
                flag = 0;
            index.next = new ListNode(sum %10);
            index = index.next;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        if (flag == 1){
            index.next = new ListNode(1);
        }
        return dummy.next;
    }
}
class ListNode{
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}
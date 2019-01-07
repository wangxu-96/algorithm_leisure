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
        l2.next.next=new ListNode(9);
        ListNode returnList=addTwoNumbers(l1,l2);
        while (returnList!=null){
            System.out.println(returnList.val);
            returnList=returnList.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode dummyHead=new ListNode(0);
        ListNode currentList=dummyHead;//temp变量，最后返回dummyHead.next()
        int flag=0;//进位标志
        while (l1!=null||l2!=null){
            int x=l1==null?0:l1.val;
            int y=l2==null?0:l2.val;
            int a=x+y+flag;
            if (a/10==1){
                flag=1;
            }else {
                flag=0;
            }
            currentList.next=new ListNode(a%10);
            currentList=currentList.next;
            if (l1!=null){
                l1=l1.next;
            }
            if (l2!=null){
                l2=l2.next;
            }
        }
        if (flag==1){
            currentList.next=new ListNode(1);
        }
        return dummyHead.next;
    }
}
class ListNode{
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}
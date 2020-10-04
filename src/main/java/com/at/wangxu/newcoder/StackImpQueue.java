package com.at.wangxu.newcoder;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class StackImpQueue {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        if (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack1.push(node);
    }

    public int pop() {
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return stack1.pop();
    }

    public static void main(String[] args) {
        StackImpQueue queue = new StackImpQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);

        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}

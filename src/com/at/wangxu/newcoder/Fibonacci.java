package com.at.wangxu.newcoder;

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
}

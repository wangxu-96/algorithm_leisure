package com.at.wangxu.leetcode;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。
 * 斐波那契数列的定义如下：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class Fibonacci {

    public int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        int[] s = new int[]{0, 1};

        for (int i = 2; i <= n; i++) {

            int a1= s[0];
            s[0] = s[1];
            s[1] = (s[1] + a1)% 1000000007;
        }
        return s[1];
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fib(7));
    }
}

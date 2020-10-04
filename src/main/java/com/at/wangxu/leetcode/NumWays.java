package com.at.wangxu.leetcode;

/**
 *
 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class NumWays {

    public int numWays(int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 1;

        int[] s = new int[]{0, 1};

        for (int i = 1; i <= n; i++) {

            int a1= s[0];
            s[0] = s[1];
            s[1] = (s[1] + a1)% 1000000007;
        }
        return s[1];
    }

    public static void main(String[] args) {
        NumWays numWays = new NumWays();
        System.out.println(numWays.numWays(7));
    }
}

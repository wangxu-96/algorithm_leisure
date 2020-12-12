package com.at.wangxu.leetcode;

/**
 * 50. Pow(x, n) https://leetcode-cn.com/problems/powx-n/
 */
public class MyPow {
    public double myPow1(double x, long n) {
        return quickMul(x, n);
    }

    public double quickMul(double x, long n) {
        if (n == 0)
            return 1.0;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double a = quickMul(x, n / 2);
        if ((n & 1) == 0) {
            return a * a;
        } else {
            return a * a * x;
        }
    }

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public static void main(String[] args) {
        MyPow myPow = new MyPow();
        System.out.println(myPow.myPow1(2.0, -2147483648));
        System.out.println(Math.pow(2.0, -2147483648));
    }
}

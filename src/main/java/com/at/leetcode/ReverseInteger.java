package com.at.leetcode;

/**
 * 7. Reverse Integer
 * Given a 32-bit signed integer, reverse digits of an integer.
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class ReverseInteger {

    public int reverse(int x){
        int sum = 0;
        while ( x != 0) {
            int p = x % 10;
            x /= 10;
            if (sum > Integer.MAX_VALUE/10 || (sum == Integer.MAX_VALUE / 10 && p > 7)) return 0;
            if (sum < Integer.MIN_VALUE/10 || (sum == Integer.MIN_VALUE / 10 && p < -8)) return 0;
            sum = sum * 10 + p;
        }
        return sum;
    }


    public static void main(String[] args) {
        ReverseInteger bean = new ReverseInteger();
        System.out.println(bean.reverse(1463847412));
    }
}

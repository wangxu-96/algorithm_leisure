package com.at.wangxu.leetcode;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class Palindrome {

    /**
     * 转换成字符串
     *
     * @param x x
     * @return true, false
     */
    public boolean isPalindrome(int x) {

        String s = String.valueOf(x);
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i])
                return false;
        }
        return true;
    }

    /**
     * 使用数字乘除
     *
     * @param x x
     * @return true false
     */
    public boolean isPalindromeInt(int x) {
        if (x < 0)
            return false;

        int temp = x;
        int sum = 0;
        int i;
        while (temp != 0) {
            i = temp % 10;
            temp = temp / 10;
            sum = sum * 10 + i;
        }
        return sum == x;
    }

    public static void main(String[] args) {

        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindrome(10));
        System.out.println(palindrome.isPalindromeInt(10));
    }
}

package com.at.wangxu.leetcode;

/**
 * 5788. 字符串中的最大奇数
 */
public class LargestOddNumber {

    public String largestOddNumber(String num) {
        String res = "";
        int length = num.length();
        for(int i = length - 1; i >= 0; i--) {
            char c = num.charAt(i);
            if(c % 2 == 1) {
                return num.substring(0, i + 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LargestOddNumber largestOddNumber = new LargestOddNumber();
        System.out.println(largestOddNumber.largestOddNumber("52"));
        System.out.println(largestOddNumber.largestOddNumber("4206"));
        System.out.println(largestOddNumber.largestOddNumber("35427"));

    }

}
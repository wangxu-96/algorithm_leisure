package com.at.wangxu.geektime.week1;

/**
 * 66. 加一 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3] 输出: [1,2,4] 解释: 输入数组表示数字 123。 示例 2:
 * 
 * 输入: [4,3,2,1] 输出: [4,3,2,2] 解释: 输入数组表示数字 4321。
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int end = digits.length - 1;
        // 进位
        int curry = 0;
        while (end >= 0) {
            int temp = digits[end];
            if (end == digits.length - 1) {
                digits[end] = (temp + curry + 1) % 10;
                curry = (temp + curry + 1) / 10;
            } else {
                digits[end] = (temp + curry) % 10;
                curry = (temp + curry) / 10;
            }
            end--;
            if (curry == 0)
                break;
        }

        if (curry > 0) {
            int[] result = new int[digits.length + 1];
            System.arraycopy(digits, 0, result, 1, digits.length);
            result[0] = curry;
            return result;
        }
        return digits;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        for (int i : plusOne.plusOne(new int[] { 9, 9, 9 })) {
            System.out.println(i);
        }
    }
}

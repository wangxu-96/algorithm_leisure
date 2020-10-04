package com.at.wangxu.leetcode;

import java.util.Arrays;

/**
 * 66. 加一
 * <p>
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) {
                carry = (digits[i] + 1) / 10;
                digits[i] = (digits[i] + 1) % 10;
            } else {
                if (carry == 0)
                    return digits;
                int temp = (digits[i] + carry);
                carry = temp / 10;
                digits[i] = temp % 10;
            }
        }
        if (carry == 1) {
            //说明最后有进位，原数组空间不够需要扩容
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, digits.length);
            return result;
        }
        return digits;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        Arrays.stream(plusOne.plusOne(new int[]{9, 9, 9})).forEach(System.out::println);
        Arrays.stream(plusOne.plusOne(new int[]{1, 2, 3})).forEach(System.out::println);
        Arrays.stream(plusOne.plusOne(new int[]{4, 3, 2, 1})).forEach(System.out::println);
    }
}

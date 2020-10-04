package com.at.wangxu.newcoder;

import java.util.Arrays;

/**
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {
    public void reOrderArray(int [] array) {
        int odd = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1){
                int temp = array[i];
                for (int j = i - 1; j >=odd ; j--) {
                    array[j+1] = array[j];
                }
                array[odd] = temp;
                //
                odd ++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        new ReOrderArray().reOrderArray(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }
}

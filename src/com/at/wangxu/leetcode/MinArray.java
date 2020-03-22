package com.at.wangxu.leetcode;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。 
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 */
public class MinArray {

//    public int minArray(int[] numbers) {
//        int index = -1;
//        for (int i = 0; i < numbers.length; i++) {
//            if (i != numbers.length-1 && numbers[i] > numbers[i+1]){
//                index = i;
//                break;
//            }
//        }
//        if (index == -1)
//            return numbers[0];
//        int[] minArray = new int[numbers.length];
//
//
//        for (int i = 0; i < minArray.length; i++) {
//            if (i <= index) {
//                minArray[i + minArray.length - 1 - index] = numbers[i];
//            } else {
//                minArray[i - index - 1] = numbers[i];
//            }
//        }
//
//        return minArray[0];
//    }

    public int minArray(int[] numbers) {

        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] > numbers[j]) i = m + 1;
            else if (numbers[m] < numbers[j]) j = m;
            else j--;
        }
        return numbers[i];


    }

    public static void main(String[] args) {
        MinArray minArray = new MinArray();
        System.out.println(minArray.minArray(new int[]{3,4,5,1,2,7}));
//        System.out.println(minArray.minArray(new int[]{3,4,5,1,2}));
//        System.out.println(minArray.minArray(new int[]{2,2,2,0,1}));
//        System.out.println(minArray.minArray(new int[]{1,3,5}));
//        System.out.println(minArray.minArray(new int[]{3,1}));
//        System.out.println(minArray.minArray(new int[]{3,1,3}));
//        System.out.println(minArray.minArray(new int[]{1,2,1}));
    }
}

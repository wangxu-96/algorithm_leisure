package com.at.wangxu.competition;

import java.util.Arrays;

/**
 * 5610. 有序数组中差绝对值之和
 */
public class GetSumAbsoluteDifferences {

    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] res = new int[nums.length];
        int[] left = new int[nums.length];
        left[0] = 0;
        int[] right = new int[nums.length];
        right[nums.length - 1] = 0;
        for (int i = 1; i < nums.length; i++) {
            left[i] = (nums[i] - nums[i - 1]) * i + left[i - 1];
        }

        for (int i = nums.length - 2; i >= 0 ; i--) {
            right[i] = Math.abs(nums[i] - nums[i + 1]) * (nums.length - 1 - i) + right[i + 1];
        }
        int index = 0;
        while (index < nums.length) {
            res[index] = left[index] + right[index];
            index ++;
        }
        return res;
    }

    public static void main(String[] args) {
        GetSumAbsoluteDifferences absoluteDifferences = new GetSumAbsoluteDifferences();
        Arrays.stream(absoluteDifferences.getSumAbsoluteDifferences(new int[]{2,3})).forEach(System.out::println);
    }
}

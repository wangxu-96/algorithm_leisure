package com.at.wangxu.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *  
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer integer = map.get(target - nums[i]);
            if (integer != null && integer != i){
                return new int[]{integer,i};
            }
            map.put(nums[i],i );
        }
        return null;
    }


    /**
     * 167. 两数之和 II - 输入有序数组
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
     *
     * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
     *
     * 说明:
     *
     * 返回的下标值（index1 和 index2）不是从零开始的。
     * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
     * 示例:
     *
     * 输入: numbers = [2, 7, 11, 15], target = 9
     * 输出: [1,2]
     * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
     * @param numbers numbers
     * @param target target
     * @return int[]
     */
    public int[] twoSumII(int[] numbers,int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            if (numbers[left] + numbers[right] == target)
                return new int[]{left + 1, right + 1};
            if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();

        Arrays.stream(twoSum.twoSum(new int[]{2, 7, 11, 15}, 9)).forEach(System.out::println);
    }
}

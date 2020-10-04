package com.at.wangxu.leetcode;

import java.util.Arrays;

/**
 * 189. 旋转数组
 * <p>
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 */
public class Rotate {


    public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            moveRightOnePlace(nums);
        }
    }

    //每次右移一位
    public void moveRightOnePlace(int[] nums) {
        int temp = nums[nums.length - 1];
        System.arraycopy(nums, 0, nums, 1, nums.length - 1 - 1 + 1);
        nums[0] = temp;
    }


    public void rotateOfficial(int[] nums, int k) {
        //reverse nums
        reverse(nums, 0, nums.length - 1);
        //reverse nums[0,k%length]
        reverse(nums, 0, k % nums.length - 1);
        //reverse nums(k%length,length-1]
        reverse(nums, k % nums.length, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        int length = end - start + 1;
        for (int i = start; i < length / 2 + start; i++) {
            //length(要翻转数组的长度) + start(数组的起始位置) - 1(数组从0开始，所以最后一个元素是length-1) - (i - start)(数组中相对于start的偏移量)
            int another = length + start - 1 - (i - start);
            int temp = nums[i];
            nums[i] = nums[another];
            nums[another] = temp;
        }
    }

    /**
     * 数组翻转
     * @param nums nums
     * @param start start 指针
     * @param end end 指针
     */
    public void reverseOfficial(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2};
        new Rotate().rotateOfficial(arr, 3);
        Arrays.stream(arr).forEach(System.out::println);
    }
}

package com.at.wangxu.geektime.week1;

/**
 * 283. 移动零
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[start];
                nums[start] = temp;
                start ++;
            }
        }
    }
}

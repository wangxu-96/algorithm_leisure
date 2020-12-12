package com.at.wangxu.leetcode;

/**
 * 659. 分割数组为连续子序列
 * https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences/
 */
public class IsPossible {

    public boolean isPossible(int[] nums) {
        int start = 0;
        int size = nums.length;
        int i = 0;
        for (i = 0; i < nums.length; i++) {
            if (start == size - 1 || i == size - 1) break;
            if (nums[i] + 1 != nums[i + 1])
                start = i + 1;
        }

        return i - start + 1 >= 3;
    }

    public static void main(String[] args) {
        IsPossible isPossible = new IsPossible();
        System.out.println(isPossible.isPossible(new int[] { 1, 2, 3, 3, 4, 5 }));
        System.out.println(isPossible.isPossible(new int[] { 1, 2, 3, 3, 4, 4, 5, 5 }));
        System.out.println(isPossible.isPossible(new int[] { 1, 2, 3, 4, 4, 5 }));
    }
}

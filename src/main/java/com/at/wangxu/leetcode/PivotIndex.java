package com.at.wangxu.leetcode;

@SuppressWarnings("unused")
public class PivotIndex {

    public int pivotIndex(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0] == 0 ? 0 : -1;
        for (int i = 1; i < nums.length; ++i) {
            nums[i] += nums[i - 1];
        }

        for (int i = 0; i < nums.length; ++i) {
            if (i == 0) {
                if (nums[nums.length - 1] - nums[0] == 0) return 0;
            } else {
                if (nums[i - 1] == nums[nums.length - 1] - nums[i])
                    return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        PivotIndex pivotIndex = new PivotIndex();
        int res = pivotIndex.pivotIndex(new int[]{1, 7, 3, 6, 5, 6});
        System.out.println(res);
    }
}

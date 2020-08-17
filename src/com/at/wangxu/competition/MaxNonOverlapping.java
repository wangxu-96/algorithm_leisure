package com.at.wangxu.competition;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 1546. 和为目标值的最大数目不重叠非空子数组数目 显示英文描述
 * 通过的用户数735
 * 尝试过的用户数1661
 * 用户总通过次数750
 * 用户总提交次数3467
 * 题目难度Medium
 * 给你一个数组 nums 和一个整数 target 。
 * <p>
 * 请你返回 非空不重叠 子数组的最大数目，且每个子数组中数字和都为 target 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1,1,1], target = 2
 * 输出：2
 * 解释：总共有 2 个不重叠子数组（加粗数字表示） [1,1,1,1,1] ，它们的和为目标值 2 。
 * 示例 2：
 * <p>
 * 输入：nums = [-1,3,5,1,4,2,-9], target = 6
 * 输出：2
 * 解释：总共有 3 个子数组和为 6 。
 * ([5,1], [4,2], [3,5,1,4,2,-9]) 但只有前 2 个是不重叠的。
 * 示例 3：
 * <p>
 * 输入：nums = [-2,6,6,3,5,4,1,2,8], target = 10
 * 输出：3
 * 示例 4：
 * <p>
 * 输入：nums = [0,0,0], target = 0
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 0 <= target <= 10^6
 */
public class MaxNonOverlapping {
    int[][] visited;
    int[] dp;
    int max = 0;
    int count;

    public int maxNonOverlapping(int[] nums, int target) {
//        visited = new int[nums.length][nums.length];
        dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            find(nums, target, i);
        }
//        max = Math.max(findMatrix(visited, 0), max);
        return count;
    }

//    public int maxNonOverlapping(int[] nums,int target){
//        int sum = 0;
//        Set<Integer> set = new HashSet<>();
//        int count = 0;
//        set.add(0);
//        for (int num : nums) {
//            sum += num;
//            if (set.contains(sum - target)) {//当前和减去target等于某一段的和，即某一段的和以后到当前的和是等于target的
//                count++;
//                sum = 0;
//                set = new HashSet<>();
//            }
//            set.add(sum);
//        }
//        return count;
//    }

    public void find(int[] nums, int target, int start) {
        int sum = 0;
        for (int i = start; i < nums.length; i++) {
            if (dp[i] == 1)
                continue;
            sum += nums[i];
            if (sum == target || nums[i] == target) {
                dp[start] = 1;
                count++;
                find(nums, target, i+1);
                break;
            }
        }
    }

    public int findMatrix(int[][] visited, int start) {

        for (int i = start; i < visited.length; i++) {
            for (int j = i; j < visited[i].length; j++) {
                if (visited[i][j] == 1) {
                    dp[start] = Math.max(dp[start], findMatrix(visited, j + 1) + 1);
                }
            }
        }

        if (start >= dp.length)
            return 0;
        return dp[start];
    }

    public static void main(String[] args) {
        MaxNonOverlapping maxNonOverlapping = new MaxNonOverlapping();
//        System.out.println(maxNonOverlapping.maxNonOverlapping(new int[]{18, 11, 0, 30, 3, 20, 8, -6, 0, 0, 0, -9, 29, 4, 10, 6, 17, 24, 7, 27, -9, 11, 8, 5, 6, 21, 0, 27, 4, 24, -5, 2, -2, 0, 12, 7, 9, 14, 26, 6, -5, -1, -4, 8, 7, -3, 2, 4, -8, 8, 2, 17, 12, 23, 24, 18, 20, 10, 4, 21, 18, 21, -8, 2, 9, 5, -5, 9, 9, 22, -8, -6, -3, 20, -2, 30, -9, 7, -7, 10, 16, 0, 29, 11, 4, 11, -8, 13, 18, -5, 20, 27, -8, 22, 15, -2, -8, 8, 22, 0, 28, 11, 29, 26, 15, 7, -2, 26, -2, 16, -2, 7, 2, 23, -3, 30, 21, 6, 24, 20, 20, 28, 8, 30, 16, 3, 15, -5, 1, 23, -6, -5, 19, -2, -2, 9, 30, 17, 26, 1, 8, 15, 25, 6, 18, 9, -5, 2, 23, 21, 17, 15, 21, 13, -2, 10, 19, 23, 0, -3, 5, 25, 0, -8, 0, -2, -2, 20, -4, 29, -7, 2, 26, 30, 4, 5, 30, 16, -1, 0, 24, 18, 13, 3, 19, 20, -6, 26, 24, 0, 22, 23, -8, 28, 7, 16, 27, 23, 20, 18, 10, -3, 2, 15, 22, 26, -4, 15, 29, 19, 17, 28, -9, -2, 27, 22, 10, 19, 30, 0, 15, 27, -6, -5, 15, -3, -9, 14, -4, -6, 24, -3, 4, 17, 0, 25, 3, 4, 9, 26, -8, 21, 7, 30, 18, 24, 2, -4, 14, 14, 26, -1, 19, 18, 25, -6, 16, 19, 5, 12, 25, -10, 9, 3, 21, 30, -10, -4, 3, 18, 14, 7, -10, 3, 25, 23, 26, 9, 12, -9, 30, -10, 12, 10, 22, 12, 0, 8, 0, 26, -1, 13, 17, 16, 2, 18, 3, 12, 12, 23, 23, -4, 19, -7, 14, 17, 2, 4, 30, 10, 0, 7, -7, 18, 5, 15, 5, 16, 17, 22, -9, 29, 8, 28, 5, 11, 8, 14, -5, 14, 1, 16, 25, 4, 5, -3, 2, 20, -2, 0, 5, 27, 5, 22, 3, 6, 12, -8, 26, -10, 20, 8, 23, 2, 19, -4, 9, 19, -9, 27, -9, 8, 25, 8, 21, 29, 20, 19, -1, 14, -1, 10, 8, 8, 24, 30, 15, 5, 30, 16, 25, -4, 19, 10, 5, 22, 17, 18, 21, 3, -4, 11, 25, 10, 15, 15, 26, 10, -6, -5, -9, 5, 15, 0, 28, 20, 11, 22, 18, 25, 21, 6, 20, 18, 11, 6, -1, -6, 10, 29, 15, 7, 19, 1, 28, 22, 13, 16, 14, 27, 7, 18, 20, -7, 27, 26, 7, 1, 11, 14, 18, -3, 27, 13, 10, 26, 12, -4, 0, -5, 19, 12, 28, 4, 30, 30, 6, 11, 22, 11, 20, 4, 16, -7, 8, 27, 11, -10, -8, 24, 0, -1, 30, 28, 14, 0, -6, -6, -5, 12, 13, 11, -10, 25, -1, -4, 13, 5, 5, -7, 3, 25, -3, 27, 14, -4, 15, -3, 28, 6, 27, 5, 8, 28, -4, 13, 9, 14, -2, -6, -7, 11, 18, -6, 3, -3, 3, 30, 22, 17, 5, 9, 3, 23, 27, -9, 13, 28, 6, -4, 6, 26, 24, 14, 4, -8, 22, -3, 26, 10, -2, 13, -2, 11, 13, -9, 17, 18, 15, -10, 15, 18, -10, 5, 13, 11, -10, 12, 15, 20, 7, 10, -10, 13, 27, -10, 5, 10, 19, 22, -7, -5, 4, 12, 9, 14, 17, -7, -9, 26, 9, 29, 21, 19, 30, -8, -10, 21, 17, -7, 16, -3, 20, 27, -5, 20, -9, 11, 20, 28, 15, 18, 18, 8, 26, 12, 22, 16, -3, 16, 3, 17, -7, 18, 26, -4, 25, 5, -3, 14, -2, 14, 27, -9, 13, 8, 15, 20, 27, 23, -9, 21, 14, 29, -8, 19, -4, -1, 3, 14, 24, 15, 9, 23, 4, 12, 11, 7, 8, 19, 19, 4, 11, 29, 28, 23, -1, 30, 15, 19, 2, 26, -4, 9, 12, -4, 8, 10, 25, 3, 21, 11, 14, 20, 26, 26, 14, 13, 25, -5, 8, 30, 18, -8, 29, -3, 14, -10, 20, 20, 3, 7, -6, -6, 12, 28, 24, 21, 1, -9, 22, -6, -8, -1, 9, 6, 13, 8, -9, 21, 3, 1, 9, -7, -1, 20, 9, 3, 30, 20, 21}, 28));
//        System.out.println(maxNonOverlapping.maxNonOverlapping(new int[]{-1,3,5,1,4,2,-9},6));
//        System.out.println(maxNonOverlapping.maxNonOverlapping(new int[]{-2,6,6,3,5,4,1,2,8},10));
//        System.out.println(maxNonOverlapping.maxNonOverlapping(new int[]{0,0,0},0));
        System.out.println(maxNonOverlapping.maxNonOverlapping(new int[]{-1,-2,8,-3,8,-5,5,-4,5,4,1},5));
    }
}

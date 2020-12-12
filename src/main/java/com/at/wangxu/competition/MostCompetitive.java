package com.at.wangxu.competition;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 单调栈问题
 * 5614. 找出最具竞争力的子序列
 * 
 * 给你一个整数数组 nums 和一个正整数 k ，返回长度为 k 且最具 竞争力 的 nums 子序列。

数组的子序列是从数组中删除一些元素（可能不删除元素）得到的序列。

在子序列 a 和子序列 b 第一个不相同的位置上，如果 a 中的数字小于 b 中对应的数字，那么我们称子序列 a 比子序列 b（相同长度下）更具 竞争力 。 
例如，[1,3,4] 比 [1,3,5] 更具竞争力，在第一个不相同的位置，也就是最后一个位置上， 4 小于 5 。
 */
public class MostCompetitive {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            //当前元素比队尾元素小，将队尾元素出栈
            //此处需要另外判断数组剩余长度够不够填满栈，不然最后答案长度可能会小于k
            while (nums[i] < stack.peek() && k - stack.size() + 1 < len - i) {
                stack.pop();
            }
            if (stack.size() < k + 1) {
                stack.add(nums[i]);
            }
        }

        int[] ret = new int[k];

        while (k > 0) {
            ret[--k] = stack.pop();
        }

        return ret;
    }

    public void dfs(int k, List<Integer> list, int[] nums, int minIndex,int[][] dp) {
        if (k == 0)
            return;
        // // find small
        // int min = Integer.MAX_VALUE;
        // for (int i = minIndex; i <= nums.length - k; i++) {
        //     // min = Math.min(min, nums[i]);
        //     if (min > nums[i]) {
        //         min = nums[i];
        //         minIndex = i;
        //     }
        // }
        
        list.add(nums[dp[minIndex][nums.length - k]]);
        minIndex = dp[minIndex][nums.length-k];
        dfs(k - 1, list, nums, minIndex + 1,dp);
    }

    //dp
    public int[][] buildDP(int[] nums) {
        //从i 到 j 的最小值所对应的下标index
        int[][] dp = new int[nums.length][nums.length];

        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = i;
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = i + 1; j < dp.length; j++) {
                if (nums[dp[i][j-1]] > nums[dp[j][j]]) {
                    dp[i][j] = dp[j][j];
                }else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        MostCompetitive competitive = new MostCompetitive();
        Arrays.stream(competitive.mostCompetitive(new int[] { 3, 5, 2, 6 }, 2)).forEach(System.out::println);
        Arrays.stream(competitive.mostCompetitive(new int[] { 2, 4, 3, 3, 5, 4, 9, 6 }, 4))
        .forEach(System.out::println);
    }
}

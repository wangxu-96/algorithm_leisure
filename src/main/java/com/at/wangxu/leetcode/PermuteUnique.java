package com.at.wangxu.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 全排列 II
 * <p>
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class PermuteUnique {
    boolean[] vis;
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        vis = new boolean[nums.length];
        dfs(lists, list, nums, 0);
        return lists;
    }

    private void dfs(List<List<Integer>> lists, List<Integer> list, int[] nums, int index) {
        if (index == nums.length){
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            list.add(nums[i]);
            vis[i] = true;
            dfs(lists, list, nums, index + 1);
            vis[i] = false;
            list.remove(index);
        }
    }

    public static void main(String[] args) {
        new PermuteUnique().permuteUnique(new int[]{1,1,2}).forEach(list -> {
            list.forEach(System.out::print);
            System.out.println();
        });
    }
}

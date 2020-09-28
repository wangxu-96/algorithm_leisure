package com.at.wangxu.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        int s = (int) Math.pow(2, nums.length);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < s; i++) {
            List<Integer> list = new ArrayList<>();
            int index = 0;
            int temp = i;
            while (index < nums.length){
                if ((temp & 1) == 1)
                    list.add(nums[index]);
                temp = temp >> 1;
                index ++;
            }
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        subsets.subsets(new int[]{1,2,3}).forEach(list -> {
            list.forEach(System.out::print);
            System.out.println();
        });
    }
}

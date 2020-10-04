package com.at.wangxu.leetcode;

import java.util.*;

/**
 * 15. 3Sum
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Example 2:
 *
 * Input: nums = []
 * Output: []
 * Example 3:
 *
 * Input: nums = [0]
 * Output: []
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        if (nums.length < 3)
            return new ArrayList<>();
        int length = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }


        List<List<Integer>> result = new ArrayList<>();
        int pre1 = nums[0] - 1 ;
        int pre2 = nums[0] - 1 ;
        for (int i = 0; i < length - 2; i++) {
            if (nums[i] == pre1)
                continue;

            pre1 = nums[i];
            for (int j = i + 1; j < length - 1; j++) {
                if (nums[j] == pre2)
                    continue;
                pre2 = nums[j];
                int sub = -nums[i] - nums[j];
                if (map.containsKey(sub) && map.get(sub) > j){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(sub);
                    result.add(list);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4});

        lists.forEach(list -> {
            list.forEach(System.out::print);
            System.out.println();
        });
    }
}

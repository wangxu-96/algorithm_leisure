package com.at.wangxu.leetcode;

import java.util.*;

/**
 * 18. 四数之和
 * <p>
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4)
            return new ArrayList<>();
        int length = nums.length;

        Arrays.sort(nums);


        List<List<Integer>> result = new ArrayList<>();
        int pre1 = nums[0] - 1;
        int pre2 = nums[0] - 1;
        int pre3 = nums[0] - 1;
        int pre4 = nums[0] - 1;
        for (int i = 0; i < length - 3; i++) {
            if (nums[i] == pre1)
                continue;
            pre1 = nums[i];
            for (int j = i + 1; j < length - 2; j++) {
                if (nums[j] == pre2)
                    continue;
                pre2 = nums[j];
                for (int k = j + 1; k < length - 1; k++) {
                    if (nums[k] == pre3)
                        continue;
                    pre3 = nums[k];

                    for (int l = k + 1; l < length; l++) {
                        if (nums[l] == pre4)
                            continue;
                        pre4 = nums[l];
                        if (nums[l] + nums[i] + nums[j] + nums[k] == target) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add(nums[l]);
                            result.add(list);
                        }
                    }
                    pre4 = nums[0] - 1;
                }
                pre3 = nums[0] - 1;
                pre4 = nums[0] - 1;
            }
            pre2 = nums[0] - 1;
            pre3 = nums[0] - 1;
            pre4 = nums[0] - 1;
        }
        return result;
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        fourSum.fourSum(new int[]{-2,-1,-1,1,1,2,2}, 0).forEach(list -> {
            list.forEach(System.out::print);
            System.out.println();
        });
//        fourSum.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0).forEach(list -> {
//            list.forEach(System.out::print);
//            System.out.println();
//        });
    }
}

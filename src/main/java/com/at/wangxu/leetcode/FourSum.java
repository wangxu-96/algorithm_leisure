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
        
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
           
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

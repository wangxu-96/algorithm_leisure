package com.at.wangxu.geektime.week1;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer integer = map.get(target - nums[i]);
            if (integer != null && integer != i){
                return new int[]{integer,i};
            }
            map.put(nums[i],i );
        }
        return null;
    }
    
}

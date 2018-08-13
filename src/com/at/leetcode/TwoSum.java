package com.at.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args){
        int[] arr={3,3};
        int target=6;
        int[] resultArr=twoSum(arr,target);
        for (int i = 0; i < resultArr.length; i++) {
            System.out.println(resultArr[i]);
        }
    }
    public static int[] twoSum(int[] nums, int target) {
        Map map=new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i]) && ((int)map.get(target-nums[i]) != i)){
                return new int[]{(int)map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}

package com.at.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *两数之和
 */
public class TwoSum {
    public static void main(String[] args){
        int[] arr={3,2,1};
        int target=6;
        int[] resultArr=twoSum1(arr,target);
        for (int i = 0; i < resultArr.length; i++) {
            System.out.println(resultArr[i]);
        }
    }

    /*public static int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++)
            for(int j=0;j<nums.length;j++)
                if (i == j)
                    continue;
                else if(nums[i] + nums[j] == target)
                    return new int[]{i,j};
        return null;
    }*/

    public static int[] twoSum1(int[] nums,int target){
        Map map=new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i]) ){
                return new int[]{(int)map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }


}

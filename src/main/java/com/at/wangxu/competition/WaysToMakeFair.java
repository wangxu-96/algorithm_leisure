package com.at.wangxu.competition;

import java.util.HashMap;
import java.util.Map;

/**
 * 5607. 生成平衡数组的方案数
 */
public class WaysToMakeFair {
    
    public int waysToMakeFair(int[] nums) {
        int preEvenSum = 0;
        int preOddSum = 0;
        Map<Integer,Integer> preEven = new HashMap<>();
        Map<Integer,Integer> preOdd = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            preEven.put(i, preEvenSum);
            preOdd.put(i, preOddSum);
            if (i % 2 == 0) {
                preEvenSum += nums[i];
            }else {
                preOddSum += nums[i];
            }
        }

        int suffixEvenSum = 0;
        int suffixOddSum = 0;
        Map<Integer,Integer> suffixEven = new HashMap<>();
        Map<Integer,Integer> suffixOdd = new HashMap<>();
        for (int i = nums.length - 1; i >= 0 ; i--) {
            suffixEven.put(i, suffixEvenSum);
            suffixOdd.put(i, suffixOddSum);
            if (i % 2 == 0) {
                suffixEvenSum += nums[i];
            }else {
                suffixOddSum += nums[i];
            }
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int finalOdd = preOdd.get(i) + suffixEven.get(i);
            int finalEven = preEven.get(i) + suffixOdd.get(i);
            if (finalOdd == finalEven) count ++;
        }
        return count;
    }

    private int delIndex(int[] nums,int delIndex) {
        int evenSum = 0;
        int oddSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i == delIndex) continue;
            else if (i < delIndex) {
                if (i % 2 == 1){
                    oddSum += nums[i];
                }else {
                    evenSum += nums[i];
                }
            }else {
                if ((i - 1) % 2 == 1){
                    oddSum += nums[i];
                }else {
                    evenSum += nums[i];
                }
            }
        }
        return oddSum == evenSum ? 1 : 0;
    }

    public static void main(String[] args) {
        WaysToMakeFair waysToMakeFair = new WaysToMakeFair();
        System.out.println(waysToMakeFair.waysToMakeFair(new int[]{2,1,6,4}));
        System.out.println(waysToMakeFair.waysToMakeFair(new int[]{1,1,1}));
        System.out.println(waysToMakeFair.waysToMakeFair(new int[]{1,2,3}));
    }
}

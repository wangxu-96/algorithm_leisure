package com.at.wangxu.competition;

import java.util.Arrays;

/**
 * 5618. K 和数对的最大数目
 */
public class MaxOperations {

    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) /2 ;
            if (nums[mid] > k) {
                end = mid - 1;
            }else if(nums[mid] < k) {
                start = mid + 1;
            }else {
                break;
            }
        }

        for (int i = end + 1; i < nums.length; i++) {
            if (nums[i] > k) break;
            if (nums[i] == k) end = i;
        }

        int index = 0;
        int count = 0;
        while (index < end) {
            int sum = nums[index] + nums[end];
            if (sum > k) {
                end --;
            }else if (sum < k) {
                index ++;
            }else {
                count ++;
                index ++;
                end --;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MaxOperations maxOperations = new MaxOperations();
        System.out.println(maxOperations.maxOperations(new int[] { 1, 2, 3, 4 }, 5));
        System.out.println(maxOperations.maxOperations(new int[] { 3, 1, 3, 4, 3 }, 6));
        System.out.println(maxOperations.maxOperations(new int[] { 3, 4 }, 1));
    }
}

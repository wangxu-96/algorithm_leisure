package com.at.wangxu.competition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class CheckArithmeticSubarrays {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> list = new ArrayList<>();
        int start = 0;
        while (start < l.length){
            list.add(isRight(nums, l[start],r[start]));
            start ++;
        }

        return list;
    }

    public boolean isRight(int[] nums,int left ,int right){

        int[] sub = new int[right - left + 1];

        for (int i = 0; i < nums.length; i++) {
            if (i >= left && i <= right){
                sub[i - left] = nums[i];
            }
        }

        Arrays.sort(sub);

        int c = 0;
        for (int i = 1; i < sub.length; i++) {
            if (i == 1)
                c = sub[i] - sub[ i - 1];
            else
                if (sub[i] - sub[i - 1] != c)return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new CheckArithmeticSubarrays().checkArithmeticSubarrays(new int[]{-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10}, new int[]{0,1,6,4,8,7}, new int[]{4,4,9,7,9,10}).forEach(System.out::println);
    }
}
